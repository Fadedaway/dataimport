/**
 * 
 */
package com.fengyun.utils;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.naming.SizeLimitExceededException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.security.MessageDigest;

/**
 * @author xiongp
 *
 */
public class UploadUtils {
	
	private static final String DOT = ".";
	
	private static final long MAX_FILE = 20 * 1024 * 1024;
	/**
	 * 上传限制为20M
	 * 
	 * @param request
	 * @return
	 * 
	 * 		<pre>
	 * 使用方式
	 * MultipartFile file = multiRequest.getFile("file");获取文件
	 * InputStream input = file.getInputStream();获取文件流
	 * File source = new File(filePath);file.transferTo(source);保存文件到本地
	 * String name = multiRequest.getParameter("name");获取参数
	 *         </pre>
	 */
	public static MultipartHttpServletRequest createMultipartHttpServletRequest(HttpServletRequest request) throws MaxUploadSizeExceededException,SizeLimitExceededException{
		return createMultipartHttpServletRequest(request, MAX_FILE);
	}

	/**
	 * @param request
	 * @param maxSize
	 *            上次限制大小 单位 Byte
	 * @return
	 * 
	 * <pre>
	 * 使用方式
	 * MultipartFile file = multiRequest.getFile("file");获取文件
	 * InputStream input = file.getInputStream();获取文件流
	 * File source = new File(filePath);file.transferTo(source);保存文件到本地
	 * String name = multiRequest.getParameter("name");获取参数
	 * </pre>
	 */
	public static MultipartHttpServletRequest createMultipartHttpServletRequest(HttpServletRequest request, long maxSize) throws MaxUploadSizeExceededException,SizeLimitExceededException{
		CommonsMultipartResolver resolver = null;
		MultipartHttpServletRequest multiRequest = null;
		resolver = new CommonsMultipartResolver();
		resolver.setDefaultEncoding("UTF-8");
		resolver.setMaxUploadSize(maxSize);// 20M
		resolver.setServletContext(request.getSession().getServletContext());
		resolver.setMaxInMemorySize(1024 * 1024);
		multiRequest = resolver.resolveMultipart(request);
		return multiRequest;
	}
	
	public static JFile tranFile(MultipartFile file, String relativePath) throws IOException{
		String realName = file.getOriginalFilename();
		JFile jfile = new JFile();
		String fileNameNoExtension = null;
		String fileExtension = null;
		if(StringUtils.contains(file.getOriginalFilename(), DOT)){
			int lastDot = StringUtils.lastIndexOf(realName, DOT);
			fileNameNoExtension = realName.substring(0, lastDot);
			fileExtension = realName.substring(lastDot+1, realName.length());
		}
		jfile.setRelativePath(relativePath);
		jfile.setFileNameNoExtension(fileNameNoExtension);
		jfile.setFileExtension(fileExtension);
		jfile.setFileContent(file.getBytes());
		return jfile;
	}
	public static JFile tranFile(MultipartFile file) throws IOException{
		return tranFile(file, null);
	}

	public  static String MD5(String s) {
		char hexDigits[]={'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
		try {
			byte[] btInput = s.getBytes();
			// 获得MD5摘要算法的 MessageDigest 对象
			MessageDigest mdInst = MessageDigest.getInstance("MD5");
			// 使用指定的字节更新摘要
			mdInst.update(btInput);
			// 获得密文
			byte[] md = mdInst.digest();
			// 把密文转换成十六进制的字符串形式
			int j = md.length;
			char str[] = new char[j * 2];
			int k = 0;
			for (int i = 0; i < j; i++) {
				byte byte0 = md[i];
				str[k++] = hexDigits[byte0 >>> 4 & 0xf];
				str[k++] = hexDigits[byte0 & 0xf];
			}
			return new String(str);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
