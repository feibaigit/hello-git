package com.aa.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.aa.common.utils.JsonUtils;
import com.aa.service.PictureUpload;

@Controller
public class PictureController {

	@Resource 
	private PictureUpload pictureUpload;
	
	@RequestMapping(value="/pic/upload")
	@ResponseBody
	public String pictureUpload(MultipartFile uploadFile){
		Map map = pictureUpload.picUpload(uploadFile);
		String json = JsonUtils.objectToJson(map);
		return json;
	}
}
