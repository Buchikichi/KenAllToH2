package to.kit.data.conversion.util;

import java.lang.Character.UnicodeBlock;
import java.util.ArrayList;
import java.util.Collections;
import java.util.function.UnaryOperator;

public class NameUtils {
	private static final String HALF_KANA = "ｧ ｱ ｨ ｲ ｩ ｳ ｪ ｴ ｫ ｵ ｶ ｶﾞｷ ｷﾞｸ ｸﾞｹ ｹﾞｺ ｺﾞｻ ｻﾞｼ ｼﾞｽ ｽﾞｾ ｾﾞｿ ｿﾞﾀ ﾀﾞﾁ ﾁﾞｯ ﾂ ﾂﾞﾃ ﾃﾞﾄ ﾄﾞﾅ ﾆ ﾇ ﾈ ﾉ ﾊ ﾊﾞﾊﾟﾋ ﾋﾞﾋﾟﾌ ﾌﾞﾌﾟﾍ ﾍﾞﾍﾟﾎ ﾎﾞﾎﾟﾏ ﾐ ﾑ ﾒ ﾓ ｬ ﾔ ｭ ﾕ ｮ ﾖ ﾗ ﾘ ﾙ ﾚ ﾛ * ﾜ ｲ ｴ ｦ ﾝ ｳﾞ";

	private static UnaryOperator<String> toKatakanaLetter = str -> {
		var ix = HALF_KANA.indexOf(str);

		if (ix == -1) {
			var ch = str.charAt(0);
			var block = UnicodeBlock.of(ch);

			if (UnicodeBlock.HIRAGANA.equals(block)) {
				ix = ch - 'ぁ';
			}
		} else {
			ix /= 2;
		}
		if (ix == -1) {
			return str;
		}
		return String.valueOf((char) ('ァ' + ix));
	};

	private static UnaryOperator<String> toHiraganaLetter = str -> {
		var ix = HALF_KANA.indexOf(str);

		if (ix == -1) {
			var ch = str.charAt(0);
			var block = UnicodeBlock.of(ch);

			if (UnicodeBlock.KATAKANA.equals(block)) {
				ix = ch - 'ァ';
			}
		} else {
			ix /= 2;
		}
		if (ix == -1) {
			return str;
		}
		return String.valueOf((char) ('ぁ' + ix));
	};

	private static String convertKana(String text, UnaryOperator<String> op) {
		var list = new ArrayList<String>();
		var chars = text.toCharArray();
		var punctuation = '\0';

		for (var ix = chars.length - 1; 0 <= ix; ix--) {
			var ch = chars[ix];

			if (ch == 'ﾞ' || ch == 'ﾟ') {
				punctuation = ch;
				continue;
			}
			var letter = String.valueOf(ch);

			if (punctuation != '\0') {
				letter += String.valueOf(punctuation);
				punctuation = '\0';
			}
			list.add(op.apply(letter));
		}
		Collections.reverse(list);
		return String.join("", list);
	}

	public static UnaryOperator<String> toKatakana = text -> {
		return convertKana(text, toKatakanaLetter);
	};

	public static UnaryOperator<String> toHiragana = text -> {
		return convertKana(text, toHiraganaLetter);
	};

	private NameUtils() {
		// nop
	}
}
