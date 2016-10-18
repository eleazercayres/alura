package br.com.casadocodigo.loja.component;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileSaver {
	
	@Autowired
    private HttpServletRequest request;

	public String grava(String baseFolder, MultipartFile file){
		
		try {
			String realPath = request.getServletContext().getRealPath("/"+baseFolder);
            String path = realPath  + "\\" + file.getOriginalFilename();
            File f = new File(realPath);
            if( !f.exists() ) f.mkdir();
            file.transferTo(new File(path));
            return baseFolder + "/" + file.getOriginalFilename();

        } catch (IllegalStateException | IOException e) {
            throw new RuntimeException(e);
        }
	}
	
}
