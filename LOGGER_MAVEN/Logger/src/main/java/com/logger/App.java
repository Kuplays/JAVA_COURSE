package com.logger;

import java.util.List;
import com.mongodb.*;
import java.util.*;
import java.text.*;

public class App 
{
    public static void main( String[] args )
    {
    	try {
	        MongoClient mongo = new MongoClient("localhost", 27017);
	        DB db = mongo.getDB("LoggerData");

	        DBCollection table = db.getCollection("messageLogs");
	        BasicDBObject doc = new BasicDBObject();

	        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			Date date = new Date();
			String dateToPass = dateFormat.format(date);
			String message = "";

			for (int i = 0; i < args.length; i++) {
				message += args[i] + " ";
			}

	        doc.put("date", dateToPass);
	        doc.put("msg", message);
	        table.insert(doc);

	        DBCursor cursor = table.find();

	        while(cursor.hasNext()) {
	        	System.out.println(cursor.next());
	        }

	        System.out.println("DONE!");

	    } catch (Exception ex) {
	    	ex.printStackTrace();
	    }

    }
}
