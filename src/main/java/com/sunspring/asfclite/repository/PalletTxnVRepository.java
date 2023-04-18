package com.sunspring.asfclite.repository;

import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import java.util.List;
import java.util.Map;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import javax.persistence.EntityManager;
import org.springframework.jdbc.core.SqlParameter;
import java.util.ArrayList;
import java.util.Arrays;
import org.springframework.jdbc.core.CallableStatementCreator;

import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import javax.persistence.EntityManager;

import org.springframework.jdbc.core.SqlOutParameter;
import org.hibernate.annotations.Any;
import com.sunspring.asfclite.dto.*;
import com.sunspring.asfclite.entity.responseStatus;


@Repository
public class PalletTxnVRepository {

    @Autowired
	private JdbcTemplate jdbcTemplate;

     // 查詢棧板箱子的 拋帳紀錄
     public List<Any> getCompleteIntoStock(String palletNumber) {
        String sql = "SELECT  pt.txn_date + 1 / 3 txn_date,"
                + " pt.txn_remark,"
                + " mi.item_number,"
                + " ptd.box_code,"
                + " ptd.txn_qty,"
                + " ptd.post_check_flag,"
                + " ptd.post_check_msg,"
                + " pt.attribute_1,"
                + " (SELECT REFERENCE"
                + " FROM sfc.qsf_slip_generate@prod"
                + " WHERE txn_id = pt.txn_id) 棧板入庫單號"
                + " FROM swm.posted_txn pt,"
                + " swm.posted_txn_d ptd,"
                + " pmc.mtl_item mi"
                + " WHERE 1 = 1"
                + " AND pt.post_txn = 'COMPLETE_INTO_STOCK'"
                + " AND pt.txn_id = ptd.txn_id"
                + " AND ptd.mtl_item_id = mi.ID"
                + " AND ptd.box_code IN(SELECT box_code"
                + " FROM (SELECT box_code,"
                + " swm_pallet_id"
                + " FROM swm.swm_pallet_dtl"
                + " UNION"
                + " SELECT box_code,"
                + " swm_pallet_id"
                + " FROM swm.swm_pallet_dtl_log) dtl,"
                + " swm.swm_pallet sp"
                + " WHERE dtl.swm_pallet_id = sp.ID"
                +  " AND pallet_number ='" + palletNumber + "')"
                + " ORDER BY 4,"
                + " 1,"
                + " 2,"
                + " 3";
        List rows = jdbcTemplate.queryForList(sql);
        // System.out.println("=======barcode  拋帳紀錄  SQL=========");
        // System.out.println(rows);

        try {
            return rows;
        } catch (DataAccessException e) {
            System.out.println(e.toString());
            return null;
        }
    }

    public List<Any> getBarcodeExchange() {
        String sql = "select  distinct tn.attribute11,"
        + " sl.new_mtl_item_number ,"
        + " sl.new_wip_entity_name  ,"
        + " SUM(tn.quantity) TOTAL,"
        + " SL.MTL_ITEM_NUMBER ,"
        + " old_wip.wip_entity_name ,"
        + " SL.LIMIT_QTY  ,"
        + " SL.ACTUAL_QTY "
        + " FROM "
        + " SWM.SWM_BARCODE_EXCHANGE_LIMIT sl,"
        + " SLM.TIN_NUMBERS tn,"
        + "         (SELECT wip_entity_id,"
        + "                 wip_entity_name,"
        + "                 assembly,"
        + "                 primary_item_id"
        + "          FROM   sfc.sfc_make_orders"
        + "          UNION"
        + "          SELECT wip_entity_id,"
        + "                 wip_entity_name,"
        + "                 assembly,"
        + "                 primary_item_id"
        + "          FROM   sfc.sfc_make_orders_his) old_wip"
        + " WHERE 1 = 1"
        + " AND tn.SOURCE_LINE_ID = sl.NEW_WIP_ENTITY_ID"
        + " AND tn.attribute11 is not null"
        + " AND tn.attribute10 = old_wip.wip_entity_id"
        + " AND old_wip.assembly = sl.mtl_item_number"
        + " GROUP BY tn.attribute11,"
        + "         sl.limit_qty,"
        + "         sl.actual_qty,"
        + "         sl.new_mtl_item_number,"
        + "         sl.MTL_ITEM_NUMBER,"
        + "         sl.new_wip_entity_name,"
        + "         old_wip.wip_entity_name "
        + " ORDER BY  tn.attribute11 DESC";
        
        List rows = jdbcTemplate.queryForList(sql);
        // System.out.println("=======barcode  拋帳紀錄  SQL=========");
        // System.out.println(rows);

        try {
            return rows;
        } catch (DataAccessException e) {
            System.out.println(e.toString());
            return null;
        }
    }

    public List<PalletTxnDto> getManualDemand( String txnDateStart,String txnDateEnd, String itemNumber, String palletNumber, String stationFromCode, String stationToCode) {
        String sql = "SELECT * "
                // + " FROM SWM.PALLET_TXN_V"
                + " FROM SWM.PALLET_TXN_DTL_HIS"
                + " WHERE 1=1";
                //+ "@WHERE";

        if (!"".equals(txnDateStart) & txnDateStart != null) {
            sql = sql + " AND TXN_DATE > TO_DATE('" + txnDateStart.trim() + "','yyyy/mm/dd HH24:MI:SS')";
        }

        if (!"".equals(txnDateEnd) & txnDateEnd != null) {
            sql = sql +  " AND TXN_DATE < TO_DATE('" + txnDateEnd.trim() + "','yyyy/mm/dd HH24:MI:SS')";
            // System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaa");
            // System.out.println(sWhere);
        }

        if (!"".equals(palletNumber) & palletNumber != null) {
            sql = sql +  " AND PALLET_NUMBER=" + "'" + palletNumber.trim()  + "'";
        }

        if (!"".equals(itemNumber) & itemNumber != null) {
        //    sWhere += " AND  ITEM_NUMBER=" + "'" + itemNumber  + "'" + "\n";
           sql = sql +  " AND ITEM_NUMBER=" + "'" + itemNumber.trim()  + "'";
        } 
        // else {
        //    sWhere += "";
        // }

        if (!"".equals(stationFromCode) & stationFromCode != null) {
            sql = sql +  " AND STATION_FROM_CODE=" + "'" + stationFromCode.trim()  + "'" ;
        }
        if (!"".equals(stationToCode) & stationToCode != null) {
            sql = sql +  " AND STATION_TO_CODE=" + "'" + stationToCode.trim()  + "'" ;
        }
     
        //sql = sql.replaceAll("@WHERE", sWhere);
        System.out.println(sql);


        List rows = jdbcTemplate.queryForList(sql);
        try {
            List<PalletTxnDto> ListData = jdbcTemplate.query(sql,
                    new BeanPropertyRowMapper<>(PalletTxnDto.class));
            return ListData;

        } catch (DataAccessException e) {
            System.out.println(e.toString());
            return null;
        }
    }

    public List<TinPoLineLocations> getTinPoLineLocations( 
        String  PO_NO,
        String  PO_RELEASE_NUM,
        String  IPO_NO,
        String  PO_SEQ,
        String  ITEM_NO,
        String  LOCATION_CODE,
        String  CUSTOM_NUMBER,
        String  TRANSACTION_ID,
        String  PO_HEADER_ID,
        String  PO_LINE_ID,
        String  PO_LINE_LOCATION_ID,
        String  ORGANIZATION_ID,
        String  CUSTOM_HDR_ID        
        ) {
//TIN_PO_LINE_LOCATIONS
        String sql = "SELECT * "
                // + " FROM SWM.PALLET_TXN_V"
                + " FROM SLM.TIN_PO_LINE_LOCATIONS"
                + " WHERE 1=1";
                //+ "@WHERE";

        if (!"".equals(PO_NO) & PO_NO != null) {
            sql = sql +  " AND PO_NO=" + "'" + PO_NO.trim()  + "'";
        }

        if (!"".equals(PO_RELEASE_NUM) & PO_RELEASE_NUM != null) {
            sql = sql +  " AND PO_RELEASE_NUM=" + "'" + PO_RELEASE_NUM.trim()  + "'";
            // System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaa");
            // System.out.println(sWhere);
        }

        if (!"".equals(IPO_NO) & IPO_NO != null) {
            sql = sql +  " AND PALLET_NUMBER=" + "'" + IPO_NO.trim()  + "'";
        }

        if (!"".equals(PO_SEQ) & PO_SEQ != null) {
        //    sWhere += " AND  ITEM_NUMBER=" + "'" + itemNumber  + "'" + "\n";
           sql = sql +  " AND ITEM_NUMBER=" + "'" + PO_SEQ.trim()  + "'";
        } 
        // else {
        //    sWhere += "";
        // }

        if (!"".equals(ITEM_NO) & ITEM_NO != null) {
            sql = sql +  " AND ITEM_NO=" + "'" + ITEM_NO.trim()  + "'" ;
        }
        //
        if (!"".equals(LOCATION_CODE) & LOCATION_CODE != null) {
            sql = sql +  " AND LOCATION_CODE=" + "'" + LOCATION_CODE.trim()  + "'";
        }

        if (!"".equals(CUSTOM_NUMBER) & CUSTOM_NUMBER != null) {
            sql = sql +  " AND CUSTOM_NUMBER=" + "'" + CUSTOM_NUMBER.trim()  + "'";
            // System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaa");
            // System.out.println(sWhere);
        }

        if (!"".equals(TRANSACTION_ID) & TRANSACTION_ID != null) {
            sql = sql +  " AND TRANSACTION_ID=" + "'" + TRANSACTION_ID.trim()  + "'";
        }

        if (!"".equals(PO_HEADER_ID) & PO_HEADER_ID != null) {
            sql = sql +  " AND PO_HEADER_ID=" + "'" + PO_HEADER_ID.trim()  + "'" ;
        }

        if (!"".equals(PO_LINE_ID) & PO_LINE_ID != null) {
            sql = sql +  " AND PO_LINE_ID=" + "'" + PO_LINE_ID.trim()  + "'" ;
        }

        if (!"".equals(PO_LINE_LOCATION_ID) & PO_LINE_LOCATION_ID != null) {
            sql = sql +  " AND PO_LINE_LOCATION_ID=" + "'" + PO_LINE_LOCATION_ID.trim()  + "'" ;
        }

        if (!"".equals(ORGANIZATION_ID) & ORGANIZATION_ID != null) {
            sql = sql +  " AND ITEM_NO=" + "'" + ORGANIZATION_ID.trim()  + "'" ;
        }

        if (!"".equals(CUSTOM_HDR_ID) & CUSTOM_HDR_ID != null) {
            sql = sql +  " AND CUSTOM_HDR_ID=" + "'" + CUSTOM_HDR_ID.trim()  + "'" ;
        }
     
        //sql = sql.replaceAll("@WHERE", sWhere);
        System.out.println(sql);


        List rows = jdbcTemplate.queryForList(sql);
        try {
            List<TinPoLineLocations> ListData = jdbcTemplate.query(sql,
                    new BeanPropertyRowMapper<>(TinPoLineLocations.class));
            return ListData;

        } catch (DataAccessException e) {
            System.out.println(e.toString());
            return null;
        }
    }


    //查詢tin的id
    public List<TinNumbersDto> getTinNumber(String boxcode) {
	  String sql = "SELECT "
			+ " tin_num_id,ATTRIBUTE9,STATUS_ID \n"
			+ " FROM "
			+ " SLM.TIN_NUMBERS \n"
			+ " WHERE 1 = 1\n"
			+ " AND    SOURCE_BARCODE_NUMBER ='" + boxcode + "'";
 	 List rows = jdbcTemplate.queryForList(sql);
     System.out.println("=======查詢tin的id=========");  
  	 System.out.println(rows);  

	 try {      
		 return rows;
	 } catch (DataAccessException e) {
		return null;
	 }
   }

    //查詢tin綁定的標籤
    public List<TinNumbersDto> getTinNumberRel(String boxcode) {
	  String sql = "SELECT "
			+ " tin_num_id \n"
			+ " FROM "
			+ " SLM.TIN_NUMBER_RELATIONS \n"
			+ " WHERE 1 = 1\n"
			+ " AND    SOURCE_BARCODE_NUMBER ='" + boxcode + "'";
 	 List rows = jdbcTemplate.queryForList(sql);
     System.out.println("=======查詢tin綁定的標籤=========");  
  	 System.out.println(rows);  

	 try {      
		 return rows;
	 } catch (DataAccessException e) {
		return null;
	 }
   }

   public List<SsgItemsDto> getSsgItems(String item) {
    String sql = "SELECT "
          + " SEGMENT1,ATTRIBUTE25,ATTRIBUTE26 \n"
          + " FROM "
          + " SLM.SSG_ITEMS \n"
          + " WHERE 1 = 1\n"
          + " AND    SEGMENT1 ='" + item + "'";
    List rows = jdbcTemplate.queryForList(sql);
    System.out.println("=======查詢item的箱容=========");  
    System.out.println(sql); 
    System.out.println(rows);  

   try {      
       return rows;
   } catch (DataAccessException e) {
      return null;
   }
 }



    public String insertTinNumberRelations(TinNumberRelationsDto data) {
        String sState = "OK";
        String sql = "";
             sql
            = "INSERT INTO SLM.TIN_NUMBER_RELATIONS \n"
            + "            (\n"
            + "             TIN_REL_ID,\n"
            + "             TIN_NUM_ID,\n"
            + "             REF_TIN_NUM_ID,\n"
            + "             CREATION_DATE,\n"
            + "             CREATED_BY,\n"
            + "             LAST_UPDATE_DATE,\n"
            + "             LAST_UPDATED_BY,\n"
            + "             LAST_UPDATE_LOGIN,\n"
            + "             ATTRIBUTE1\n"
            + ") VALUES      ( APPS.TIN_NUMBER_RELATIONS_s1.NEXTVAL, \n";
            sql = sql + data.getTIN_NUM_ID() +   ",\n";
            sql = sql +  data.getREF_TIN_NUM_ID() +   ",\n";
            sql = sql +  "SYSDATE,\n";
            sql = sql +  "-1,\n";
            sql = sql +  "SYSDATE,\n";
            sql = sql +  "-1,\n";
            sql = sql +  "-1,\n";
            sql = sql +  "2 \n";
            sql = sql + ")\n";
            System.out.println("======insertTinNumberRelations====="); 
            System.out.println(sql);  
            try {
                jdbcTemplate.execute(sql);
                sState = "OK";
            } catch (Exception e) {
                sState = "NG";
            }
        // }
        return sState;
    }

    public String updataTinNumberRelations(TinNumberRelationsDto data) {
        String sState = "OK";
        String sql = "";
            sql = "Update SLM.TIN_NUMBER_RELATIONS Set \n"
                    + " TIN_NUM_ID='" + data.getTIN_NUM_ID() + "'\n"
                    + " ,ATTRIBUTE1='" + data.getREF_TIN_NUM_ID() + "'\n"
                    + " where 1=1 \n"
                    + " and   TIN_NUM_ID='" +  data.getREF_TIN_NUM_ID() + "'\n";
                    System.out.println("=====updataTinNumberRelations====");  
                    System.out.println(sql); 
            try {
                jdbcTemplate.execute(sql);
                sState = "OK";
            } catch (Exception e) {
                sState = "NG";
            }
        return sState;
    }

    public List<TinNumbersDto> updataTinNumbers(String TIN_NUM_ID,String QUANTITY,String STATUS_ID,String ATTRIBUTE9) {
        String sState = "OK";
        String sql = "";
            sql = "Update SLM.TIN_NUMBERS Set \n"
                    + "	 @SET \n"
                    // + " quantity = 0 , status_id = 2 \n"  
                    + " where 1=1 \n"
                    + " and   TIN_NUM_ID in (" +  TIN_NUM_ID + ") \n";
                    String setstr = "";
                    if (!"".equals(QUANTITY) && QUANTITY != null) {
                        setstr = setstr + " QUANTITY=" + QUANTITY + ",\n";
                    }
                    if (!"".equals(STATUS_ID) && STATUS_ID != null) {
                        setstr = setstr + " STATUS_ID=" + STATUS_ID + ",\n";
                    }
                    if (!"".equals(ATTRIBUTE9) && ATTRIBUTE9 != null) {
                        setstr = setstr + " ATTRIBUTE9=" + ATTRIBUTE9 + ",\n";
                    }
            
                    if (!"".equals(setstr) && setstr != null) {
                        //去尾,
                        setstr =  setstr.substring(0, setstr.length()  -2);
                        sql = sql.replaceAll("@SET", setstr);
                    } else {
                        sState = "NG";
                    }
                    System.out.println(sql);  
            try {
                jdbcTemplate.execute(sql);
                sState = "OK";
            } catch (Exception e) {
                sState = "NG";
            }
        return null;
    }

  

    public String createTinNumbersPo(String p_pallet_number) {
        String type = "OK";
        List<SqlParameter> parameters = Arrays.asList(
                //               new SqlOutParameter("message", Types.VARCHAR),
                new SqlParameter(Types.VARCHAR));

        Map<String, Object> t;
        t = jdbcTemplate.call(new CallableStatementCreator() {

            public CallableStatement createCallableStatement(Connection con) throws SQLException {

                try {
                    CallableStatement callableStatement = con.prepareCall("{call  ssgtinc002.create_tin_numbers_po(?)}");
                    callableStatement.setString(1, p_pallet_number);
                    return callableStatement;
                } catch (SQLException e) {
                    CallableStatement callableStatement = con.prepareCall("");

                    return callableStatement;
                }
            }

        }, parameters);
        return type;
    }
  
    

    
}
