package models.define;

/**
 * <strong>BSValidatorConst</strong><br>
 * <br>
 * We should use pattern validate for entry box
 * <ul>
 * <li>Text entry : @NotMatchPattern(pattern = CSValidatorConst.PATTERN_REG_PROHIBIT_CHAR, message =
 * CSValidatorConst.PATTERN_MSG_PROHIBIT_CHAR)
 * <li>Tel/Fax entry : @MatchPattern(pattern = CSValidatorConst.PATTERN_REG_FORMAT_TEL, message = CSValidatorConst.PATTERN_MSG_FORMAT_TEL)
 * </ul>
 * the example for pattern(ref:http://oval.sourceforge.net/api/index.html)
 * <ul>
 * <li> decimal number: "^-{0,1}(\\d*|(\\d{1,3}([,]\\d{3})*))[.]?\\d*$"
 * <li> numbers only: "^\\d*$"
 * <li> e-mail address: "^([a-z0-9]{1,}[\\.\\_\\-]?[a-z0-9]{1,})\\@([a-z0-9]{2,}\\.)([a-z]{2,2}|org|net|com|gov|edu|int|info|biz|museum)$"
 * </ul>
 * 
 * @author hoangdx
 * @version $Id$
 */
public class BSValidatorConst{

	/**
	 * PATTERN_PROHIBIT_CHAR
	 * -> \ / : ; *　? " < > , |
	 */
	public static final String	PATTERN_REG_PROHIBIT_CHAR		= "^.*[\\\\|/|:|;|\\*|?|\"|<|>|,|\\|].*$";
	public static final String	PATTERN_MSG_PROHIBIT_CHAR		= "oval.alert.pattern.prohibition";

	/**
	 * PATTERN_REG_FORMAT_ACCOUNT
	 * ok : user001
	 * ng : 1user
	 */
	public static final String	PATTERN_REG_FORMAT_ACCOUNT		= "^([a-z0-9]{1,}[\\.\\_\\-]?[a-z0-9]{1,})";
	public static final String	PATTERN_MSG_FORMAT_ACCOUNT		= "oval.alert.pattern.account";

	// (^([0-9]|[a-z]|[A-Z])+$)
	public static final String	PATTERN_REG_FORMAT_PASSWORD		= "(?!^[^0-9]*$)(?!^[^A-Za-z]*$)(?!^[^(\\!-\\/|:-@|\\[-`|{-~]*$)^([\\!-~]+)$";
	public static final String	PATTERN_MSG_FORMAT_PASSWORD		= "oval.alert.pattern.password";

	public static final String	PATTERN_REG_FORMAT_PASSWORD_BS	= "^[0-9a-zA-Z]+$";
	public static final String	PATTERN_MSG_FORMAT_PASSWORD_BS	= "oval.alert.pattern.password.bs";

	/** PATTERN_REG_FORMAT_HALFCHAR(use : alphabet, number, symbol) */
	public static final String	PATTERN_REG_FORMAT_HALFCHAR		= "^[a-zA-Z0-9 -/:-@\\[-\\`\\{-\\~]+$";
	public static final String	PATTERN_MSG_FORMAT_HALFCHAR		= "oval.alert.pattern.halfchar";

	/** PATTERN_REG_FORMAT_TEL(use : alphabet, number, -) */
	public static final String	PATTERN_REG_FORMAT_TEL			= "^[a-zA-Z0-9 -]+$";
	public static final String	PATTERN_MSG_FORMAT_TEL			= "oval.alert.pattern.tel";

	/** PATTERN_REG_FORMAT_TEL2(use : number, -) */
	public static final String	PATTERN_REG_FORMAT_TEL2			= "^[0-9 -]+$";
	public static final String	PATTERN_MSG_FORMAT_TEL2			= "oval.alert.pattern.tel2";

	/** PATTERN_REG_FORMAT_TEL(use : 999-9999 style) */
	public static final String	PATTERN_REG_FORMAT_POST			= "^[0-9]{3}-[0-9]{4}$";
	//public static final String	PATTERN_REG_FORMAT_POST			= "^[0-9][0-9][0-9]-[0-9][0-9][0-9][0-9]$";
	public static final String	PATTERN_MSG_FORMAT_POST			= "oval.alert.pattern.post";

	/** PATTERN_REG_FORMAT_TEL(use : 9999/99/99) */
	public static final String	PATTERN_REG_FORMAT_DATE			= "\\d{4}/\\d{1,2}/\\d{1,2}";
	public static final String	PATTERN_MSG_FORMAT_DATE			= "oval.alert.pattern.date";

	/** PATTERN_REG_FORMAT_TEL(use : 99:99) */
	public static final String	PATTERN_REG_FORMAT_TIME			= "^[0-9].:[0-9].$";
	public static final String	PATTERN_MSG_FORMAT_TIME			= "oval.alert.pattern.time";

	// validate message constant
	public static final String	PATTERN_REG_FORMAT_EMAIL		= "^([a-z0-9]{1,}[\\.\\_\\-]?[a-z0-9]{1,})\\@([a-z0-9]{2,}\\.)([a-z]{2,2}|asia|org|net|com|gov|edu|int|info|biz|museum)$";
	public static final String	PATTERN_MSG_FORMAT_EMAIL		= "oval.alert.pattern.email";
	public static final String	EQUAL_TO_FIELD_VIOLATED_EMAIL	= "bs.oval.constraint.EqualToField.violated.email";
	public static final String	EQUAL_TO_FIELD_VIOLATED_PASS	= "bs.oval.constraint.EqualToField.violated.pass";

}