package to.kit.data.conversion.service;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;
import java.util.zip.ZipInputStream;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;
import org.springframework.util.StreamUtils;

import to.kit.data.conversion.dto.KenAllRecord;
import to.kit.data.conversion.util.NameUtils;

@Service
@ConfigurationProperties(prefix = "loader")
public class KenAllLoader {
	private String charsetName;
	private UnaryOperator<String> op = NameUtils.toHiragana;

	private void load(List<KenAllRecord> list, byte[] bytes) throws IOException {
		try (var in = new ByteArrayInputStream(bytes);
				var isr = new InputStreamReader(in, this.charsetName);
				var reader = new BufferedReader(isr)) {
			for (;;) {
				var line = reader.readLine();

				if (line == null) {
					break;
				}
				var rec = new KenAllRecord();
				var elements = line.replaceAll("\"", "").split(",");
				var prefectureKana = this.op.apply(elements[3]);
				var municipalityKana = this.op.apply(elements[4]);
				var areaKana = this.op.apply(elements[5]);

				rec.setX0402(elements[0]);
				rec.setOldZip(elements[1]);
				rec.setNewZip(elements[2]);
				rec.setPrefectureKana(prefectureKana);
				rec.setMunicipalityKana(municipalityKana);
				rec.setAreaKana(areaKana);
				rec.setPrefecture(elements[6]);
				rec.setMunicipality(elements[7]);
				rec.setArea(elements[8]);
				rec.setDupAreaFlag(elements[9]);
				rec.setBanFlag(elements[10]);
				rec.setChomeFlag(elements[11]);
				rec.setDupZipFlag(elements[12]);
				rec.setUpdate(elements[13]);
				rec.setReason(elements[14]);
				list.add(rec);
			}
		}
	}

	public List<KenAllRecord> load(File file) throws IOException {
		var list = new ArrayList<KenAllRecord>();

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
