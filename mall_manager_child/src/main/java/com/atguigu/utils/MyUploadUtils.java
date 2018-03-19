package com.atguigu.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class MyUploadUtils {

	public static List<String> uploadimage(MultipartFile[] files) {
		List<String> list_image = new ArrayList<String>();
		//�ϴ�ͼƬ
		for(int i = 0;i < files.length;i++) {
			//����ͼƬ��
			String filename = "";
			//��ȡͼƬ��ԭʼ����
			String originalFilename = files[i].getOriginalFilename();
			filename = System.currentTimeMillis() + originalFilename;
			
			//ͼƬ�Ĵ洢��ַ
			String path_img = "";
			path_img=imgPathUtils.getimgPath("path.properties","windown_img_path");
			System.out.println(path_img);
			try {
				files[i].transferTo(new File(path_img + "/" + filename));
				list_image.add(filename);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list_image;
	}

}
