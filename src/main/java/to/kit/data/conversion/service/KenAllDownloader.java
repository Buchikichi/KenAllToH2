package to.kit.data.conversion.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.http.HttpHost;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.springframework.stereotype.Service;
import org.springframework.util.StreamUtils;

@Service
public class KenAllDownloader {
	public void download(String url, File file) {
		var httpclient = HttpClients.custom();
		var proxy = HttpHost.create("http://192.168.3.1:8080");
		var httpget = new HttpGet(url);

		httpclient.setProxy(proxy);
		try (var response = httpclient.build().execute(httpget)) {
			var entity = response.getEntity();

			if (entity == null) {
				return;
			}
			try (InputStream in = entity.getContent(); OutputStream out = new FileOutputStream(file)) {
				StreamUtils.copy(in, out);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
