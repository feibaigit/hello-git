package com.aa.service.impl;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.aspectj.util.FileUtil;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;

import com.aa.common.utils.FtpUtil;
import com.aa.common.utils.IDUtils;
import com.aa.service.PictureUpload;

public class PictureUploadInpl implements PictureUpload{

	@Value("${FTP_POST}")
	private String FTP_POST;
	
	@Value("${FTP_USERNAME}")
	private String FTP_USERNAME;
	
	@Value("${FTP_PASSWORD}")
	private String FTP_PASSWORD;
	
	@Value("${FTP_POT}")
	private Integer FTP_POT;
	
	@Value("${FILI_UPLOAD_PATH}")
	private String FILI_UPLOAD_PATH;
	
	@Value("${IMAGE_BASE_URL}")
	private String IMAGE_BASE_URL;

	@Override
	public Map picUpload(MultipartFile uploadFile) {
		Map map = new HashMap<>();
		try {
			//d得到图片本来的名称
			String filename = uploadFile.getOriginalFilename();
			
			//创建图片在服务器上的名称
			String genImageName = IDUtils.genImageName();
			genImageName += filename.substring(filename.lastIndexOf("."));
			
			//图片上路径
			
			String filePath = new DateTime().toString("yyyy/MM/dd");
			
			boolean result = FtpUtil.uploadFile(FTP_POST, FTP_POT, FTP_USERNAME, FTP_PASSWORD, IMAGE_BASE_URL, filePath, filename, uploadFile.getInputStream());
			
			if(!result){
				map.put("error", 1);
				map.put("message", "上传失败");
				return map;
			}
			map.put("error", 0);
			map.put("url", "上传成功");
			return map;
			
		} catch (Exception e) {
			e.printStackTrace();
			map.put("error", 1);
			map.put("message", "上传失败");
			return map;
		}
	}

}
