package com.fdo.vo;

import java.io.File;

public class DeleFileName {
	
	public void clearFiles(String path){
		File file = new File(path);
		if (file.exists()) {
			deleFile(file);
		}
	}
	public void deleFile(File file){
		if (file.isDirectory()) {
			File[] files = file.listFiles();
			for (int i = 0; i < files.length; i++) {
				deleFile(files[i]);
			}
		}
		file.delete();
	}


}
