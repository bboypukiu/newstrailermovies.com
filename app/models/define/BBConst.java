package models.define;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * <strong>BBConst</strong><br>
 * <br>
 *
 * @author hoangdx
 * @version $Id$
 */
public class BBConst{

	public static final String			SESSION_KEY_ACTIVE_PJ		= "active.project";

	/**
	 * language support const
	 */
	public static final String			ENGLISH_LANGUAGE_KEY		= "en";
	public static final String			JAPAN_LANGUAGE_KEY			= "ja";

	/**
	 * third party login
	 */
	public static final String			LOGIN_BY_FACEBOOK			= "F";
	public static String				FACEBOOK_SECRETKEY			= "5f783f95be3d1634b79d6a864bd897a3";

	/*
	 * Common date format
	 */
	public static String				SDF_DATE_SLS				= "yyyy/MM/dd";

	public static String				SERVICE_CD_PROJECT			= "P";
	public static String				SERVICE_CD_MINUTES			= "M";
	public static String				SERVICE_CD_ITEM				= "I";

	public static int					MINUTES_CONTENTS_ADD		= 10;
	public static int					LIMIT_ATTACHMENT_LENGTH		= 50;

	/**
	 * Project status
	 */
	public static String				PROJECT_STATUS_ACTIVE		= "A";
	public static String				PROJECT_STATUS_DONE			= "D";

	public static Map<String, String>	PROJECT_STATUS_MAP			= new LinkedHashMap<String, String>();
	static{
		PROJECT_STATUS_MAP.put(PROJECT_STATUS_ACTIVE, "project.data.status.active");
		PROJECT_STATUS_MAP.put(PROJECT_STATUS_DONE, "project.data.status.done");
	}

	/**
	 * Project user permission
	 */
	public static String				USER_PERMISSION_ADMIN		= "A";
	public static String				USER_PERMISSION_EDIT		= "E";
	public static String				USER_PERMISSION_VIEW		= "V";

	// check user permission for edit
	public static Set<String>			USER_PERMISSION_EDIT_SET	= new HashSet<String>();
	static{
		USER_PERMISSION_EDIT_SET.add(USER_PERMISSION_ADMIN);
		USER_PERMISSION_EDIT_SET.add(USER_PERMISSION_EDIT);
	}

	// show user select box for project form
	public static Map<String, String>	USER_PERMISSION_MAP			= new LinkedHashMap<String, String>();
	static{
		USER_PERMISSION_MAP.put(USER_PERMISSION_ADMIN, "project.data.user.permission.admin");
		USER_PERMISSION_MAP.put(USER_PERMISSION_EDIT, "project.data.user.permission.edit");
		USER_PERMISSION_MAP.put(USER_PERMISSION_VIEW, "project.data.user.permission.view");
	}
	/**
	 * Minutes status
	 */
	public static String				MINUTES_STATUS_WORKING		= "W";
	public static String				MINUTES_STATUS_DONE			= "D";

	public static Map<String, String>	MINUTES_STATUS_MAP			= new LinkedHashMap<String, String>();
	static{
		MINUTES_STATUS_MAP.put(MINUTES_STATUS_WORKING, "minutes.data.status.working");
		MINUTES_STATUS_MAP.put(MINUTES_STATUS_DONE, "minutes.data.status.done");
	}

	/**
	 * Response Status
	 */
	public static final String			USED					= "-1";
	public static final String			LOCKED					= "-2";
	public static final String			EXPRIED					= "-3";
	public static final String			NOT_ACTIVE				= "-4";
	public static final String			INVALID_TRANSACTION_ID	= "-5";
	public static final String			CODE_NOT_SERI			= "-6";
	public static final String			TRANSACTION_ERROR		= "-8";
	public static final String			MAX_DEMO				= "-9";
	public static final String			INVALID_CARD_ID			= "-10";
	public static final String			INVALID_CARD_CODE		= "-11";
	public static final String			NOT_EXIST				= "-12";
	public static final String			INVALID_CONTRUCTOR		= "-13";
	public static final String			NOT_EXIST_TYPE			= "-14";
	public static final String			NOT_INFOR_CUS			= "-15";
	public static final String			INVALID_TRANSACTION		= "-16";
	public static final String			INVALID_FUNCTION		= "-90";
	public static final String			ERROR_SYSTEM_1			= "-98";
	public static final String			ERROR_SYSTEM_2			= "-99";
	public static final String			ERROR_SYSTEM_TELCO		= "-999";
	public static final String			SUS_TRAN				= "-100";

	/**
	 *
	 * Telco code
	 *
	 */
	public static final String			VIETTEL					= "VTEL";
	public static final String			VINAPHONE				= "VINA";
	public static final String			MOBILEPHONE				= "MOBI";
	public static final String			ZING					= "ZING";
	public static final String			VCOIN					= "VCOIN";
}