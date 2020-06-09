package util;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;

public class JSONUtilAction {


	/**
	 * 统一返回JSON格式数据
	 * 
	 * @param response
	 * @param json
	 */
	public void writeJSONStringToResponse(HttpServletResponse response,  
            String json) {  
        response.setCharacterEncoding("utf-8");  
        response.setContentType("application/json");
        response.setHeader("Cache-Control", "no-cache");
        PrintWriter pw = null;  
        try {  
            pw = response.getWriter();  
            pw.print(json);  
            pw.flush();  
        } catch (IOException e) {  
            e.printStackTrace();  
		} finally {
			if (pw != null)
				pw.close();
		}
    }
	
	/**
	 * 统一返回JSON格式数据
	 * 
	 * @param response
	 * @param json
	 */
	public void writeJSONStringToResponse(HttpServletResponse response,  
            Object result) {  
        response.setCharacterEncoding("utf-8");  
        response.setContentType("application/json");
        response.setHeader("Cache-Control", "no-cache");
        PrintWriter pw = null;  
        String json = "[]";
        
        if(result != null){
	        ObjectMapper mapper = new ObjectMapper();
			try {
				json = mapper.writeValueAsString(result);
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
        }
        
        try {  
            pw = response.getWriter();  
            pw.print(json);  
            pw.flush();  
        } catch (IOException e) {  
            e.printStackTrace();  
		} finally {
			if (pw != null)
				pw.close();
		}
    }
	
	/**
	 * @param response
	 * @param filename
	 * @param inputStream
	 * 
	 */
	public void writeStreamToResponse(HttpServletResponse response,String filename, InputStream inputStream) {
		//response.reset();
		
		if(true){
			BufferedInputStream br = new BufferedInputStream(inputStream);
			response.setCharacterEncoding("UTF-8");
			response.setContentType("application/octet-stream");
			response.addHeader("Content-Disposition", "inline;filename="+filename); 
			
			OutputStream out = null;
			try {
				out = response.getOutputStream();
				int len = 0;
				byte[] buf = new byte[2048];
				
				while((len = br.read(buf) ) > 0) {
					out.write(buf, 0, len);
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				
				if(br != null) {
					try {
						br.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				
				if(out != null) {
					try {
						out.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				
				if(inputStream != null) {
					try {
						inputStream.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
			
			
		}
	}
	
	
	public static Map getValue(Object thisObj) {
		Map map = new HashMap();
		Class c;
		try {
			c = Class.forName(thisObj.getClass().getName());
			Method[] m = c.getMethods();
			for (int i = 0; i < m.length; i++) {
				String method = m[i].getName();
				if (method.startsWith("get")) {
					try {
						Object value = m[i].invoke(thisObj);
						if (value != null) {
							String key = method.substring(3);
							key = key.substring(0, 1).toUpperCase()
									+ key.substring(1);
							map.put(method, value);
						}
					} catch (Exception e) {
						System.out.println("error:" + method);
					}
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return map;
	}
	
	public String getEncodingParam(HttpServletRequest request,String key) {
		String value = request.getParameter(key);
		if(!StringUtils.isEmpty(value)){
			try {
				value = new String(value.getBytes("iso8859-1"),"UTF-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return value;
	}

}
