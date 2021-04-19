package model;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UncheckedIOException;

import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

public class TestCV {
	
	public String loadFileXML() {
		Resource resource = new DefaultResourceLoader().getResource("classpath:xml/smallCV.xml");
		try (Reader reader = new InputStreamReader(resource.getInputStream())) {
			return FileCopyUtils.copyToString(reader);
		} catch (IOException e) {
			e.printStackTrace();
			throw new UncheckedIOException(e);
		}
	}

	@PostMapping(value = "/postcv", produces = MediaType.APPLICATION_XML_VALUE)
	@ResponseBody
	public String postCV() {
		TestCV cv = new TestCV();
		return cv.loadFileXML();
	}

}
