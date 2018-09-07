package to.kit.data.conversion.service;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.function.UnaryOperator;
import java.util.zip.ZipInputStream;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;
import org.springframework.util.StreamUtils;

import to.kit.data.conversion.entity.KenAll;
import to.kit.data.conversion.util.NameUtils;

@Service
@ConfigurationProperties(prefix = "loader")
public class KenAllLoader {
	private String charsetName;
	private UnaryOperator<String> op = NameUtils.toHiragana;

	private void load(List<KenAll> list, byte[] bytes) throws IOException {
		try (var in = new ByteArrayInputStream(bytes);
				var isr = new InputStreamReader(in, this.charsetName);
				var reader = new BufferedReader(isr)) {
			for (;;) {
				var line = reader.readLine();

				if (line == null) {
					break;
				}
				var rec = new KenAll();
				var uuid = UUID.randomUUID().toString().replace("-", "");
				var elements = line.replaceAll("\"", "").split(",");
				var x0402 = elements[0];
				var prefKana = this.op.apply(elements[3]);
				var municipalityKana = this.op.apply(elements[4]);
				var cityKana = this.op.apply(elements[5]);

				rec.setId(uuid);
				rec.setX0401(x0402.substring(0, 2));
				rec.setX0402(x0402);
				rec.setZip5(elements[1]);
				rec.setZip7(elements[2]);
				rec.setPrefKana(prefKana);
				rec.setMunicKana(municipalityKana);
				rec.setCityKana(cityKana);
				rec.setPref(elements[6]);
				rec.setMunic(elements[7]);
				rec.setCity(elements[8]);
				rec.setSomeCity("1".equals(elements[9]));
				rec.setSomeNumber("1".equals(elements[10]));
				rec.setSomeChome("1".equals(elements[11]));
				rec.setSomeZip("1".equals(elements[12]));
				rec.setUpdate(elements[13]);
				rec.setReason(elements[14]);
				list.add(rec);
			}
		}
	}

	public List<KenAll> load(File file) throws IOException {
		var list = new ArrayList<KenAll>();

		try (var in = new FileInputStream(file); var zip = new ZipInputStream(in)) {
			for (;;) {
				var entry = zip.getNextEntry();

				if (entry == null) {
					break;
				}
				byte[] bytes = StreamUtils.copyToByteArray(zip);

				load(list, bytes);
			}
		}
		return list;
	}

	/**
	 * @return the charsetName
	 */
	public String getCharsetName() {
		return this.charsetName;
	}
	/**
	 * @param charsetName the charsetName to set
	 */
	public void setCharsetName(String charsetName) {
		this.charsetName = charsetName;
	}
}
