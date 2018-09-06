package to.kit.data.conversion;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import to.kit.data.conversion.service.KenAllDownloader;
import to.kit.data.conversion.service.KenAllLoader;

@Component
public class KenAllToH2 implements CommandLineRunner {
	@Autowired
	private KenAllDownloader downloader;
	@Autowired
	private KenAllLoader loader;

	@Override
	public void run(String... args) throws Exception {
		if (args.length < 1) {
			return;
		}
		var url = args[0];
		var file = new File("ken_all.zip");

		if (!file.exists()) {
			this.downloader.download(url, file);
		}
		var list = this.loader.load(file);

		System.out.println("list:" + list.size());
	}
}
