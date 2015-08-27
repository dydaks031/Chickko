package kr.chickko.util;
import java.io.*;
import java.util.zip.*;

import org.apache.tomcat.util.codec.binary.Base64;

public class ZIPPER 
{
	public static String zip(String param) 
	{
		try {
			byte[] unzip = param.getBytes("UTF-8");
						
			ByteArrayInputStream bif = new ByteArrayInputStream(unzip);
			ByteArrayOutputStream zipbof = new ByteArrayOutputStream();
//			DeflaterOutputStream dos = new DeflaterOutputStream(zipbof);
			GZIPOutputStream gos = new GZIPOutputStream(zipbof);
			int position = 0;

			for (int read_byte = 0; (read_byte = bif.read()) != -1; position++) 
			{
//				dos.write(read_byte);
				gos.write(read_byte);
			}
			 
//			dos.finish();
			gos.finish();
			zipbof.flush();

			byte[] zipbyteArray = zipbof.toByteArray();
//			return new sun.misc.BASE64Encoder().encode(zipbyteArray);
			return Base64.encodeBase64String(zipbyteArray);
		} 
		catch (Exception ex) 
		{
			return null;
		}
	}
	
	public static String unzip(String param) 
	{
		try 
		{
//			byte[] zipArray = new sun.misc.BASE64Decoder().decodeBuffer(param);
			byte[] zipArray = Base64.decodeBase64(param);
			
			ByteArrayInputStream bif = new ByteArrayInputStream(zipArray);
//			InflaterInputStream iis = new InflaterInputStream(bif);
			GZIPInputStream gis = new GZIPInputStream(bif);
			ByteArrayOutputStream unZipbof = new ByteArrayOutputStream();
			int position = 0;
//			for (int read_byte = 0; (read_byte = iis.read()) != -1; position++) {
			for (int read_byte = 0; (read_byte = gis.read()) != -1; position++) {
				unZipbof.write(read_byte);
			}
			unZipbof.flush();

			byte[] unZipbyteArray = unZipbof.toByteArray();
			String returnUnZipString = new String(unZipbyteArray, "UTF-8");
			return returnUnZipString;
		} catch (Exception ex) {
			return null;
		}
	}
}
