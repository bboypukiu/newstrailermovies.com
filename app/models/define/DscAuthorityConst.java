package models.define;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * <strong>BBAuthorityConst</strong><br>
 * <br>
 *
 * @author hoangdx
 * @version $Id$
 */
public class DscAuthorityConst{

	public static final String	ROLE_ADMIN				= "ROLE_ADMIN";

	public static final String	ROLE_CSKH1				= "ROLE_CSKH1";

	public static final String	ROLE_CSKH2					= "ROLE_CSKH2";

	public static final String	ROLE_ANONYMOUS			= "anonymous";

	//public static final String	PC_ACTION_PERMIT_ALL	= "PERMIT_ALL";

	public static final String	ROLE_CP				= "ROLE_CP";

	public static Map<String, String> ROLE_MAP = new LinkedHashMap<String, String>();
	static {
		ROLE_MAP.put(ROLE_ADMIN, "item.data.author.role.admin");
		ROLE_MAP.put(ROLE_CSKH1, "item.data.author.role.cskh1");
		ROLE_MAP.put(ROLE_CSKH2, "item.data.author.role.cskh2");
		//ROLE_MAP.put(ROLE_ANONYMOUS, "item.data.author.role.anonymous");
		//ROLE_MAP.put(PC_ACTION_PERMIT_ALL, "item.data.author.role.permitall");
	}
}