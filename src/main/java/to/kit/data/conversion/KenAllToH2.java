package to.kit.data.conversion;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import to.kit.data.conversion.service.KenAllDownloader;
import to.kit.data.conversion.service.KenAllLoader;
import to.kit.data.conversion.service.KenAllWriter;

@Component
public class KenAllToH2 implements CommandLineRunner {
	private static final Logger LOG = LoggerFactory.getLogger(KenAllToH2.class);
	@Autowired
	private KenAllDownloader downloader;
	@Autowired
	private KenAllLoader loader;
	@Autowired
	private KenAllWriter writer;

	@Override
	public void run(String... args) throws Exception {
		if (args.length < 1) {
			return;
		}
		var url = args[0];
		var file = new File("ken_all.zip");

		if (!file.exists()) {
			LOG.info("Download:{}", url);
			this.downloader.download(url, file);
		}
		LOG.info("Load:{}", file.getName());
		var list = this.loader.load(file);

		LOG.info("Write:{}", Integer.valueOf(list.size()));
		this.writer.save(list);
		LOG.info("Done.");
	}
}
