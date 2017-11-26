package com.aa.service;

import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

public interface PictureUpload {

	Map picUpload(MultipartFile uploadFile);
}
