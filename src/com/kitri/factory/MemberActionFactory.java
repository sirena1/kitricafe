package com.kitri.factory;

import com.kitri.action.*;
import com.kitri.member.action.*;

public class MemberActionFactory {

	private static Action idCheckAction;
	private static Action zipSearchAction;
	private static Action registerAction;
	private static Action memberInfoAction;
	private static Action modifyAction;
	private static Action deleteAction;
	private static Action loginAction;
	private static Action logoutAction;
	
	static {
		idCheckAction = new IdCheckAction();
		zipSearchAction = new ZipSearchAction();
		registerAction = new RegisterAction();
		memberInfoAction = new MemberInfoAction();
		modifyAction = new ModifyAction();
		deleteAction = new DeleteAction();
		loginAction = new LoginAction();
		logoutAction = new LogoutAction();
	}

	public static Action getIdCheckAction() {
		return idCheckAction;
	}

	public static Action getZipSearchAction() {
		return zipSearchAction;
	}

	public static Action getRegisterAction() {
		return registerAction;
	}

	public static Action getMemberInfoAction() {
		return memberInfoAction;
	}

	public static Action getModifyAction() {
		return modifyAction;
	}

	public static Action getDeleteAction() {
		return deleteAction;
	}

	public static Action getLoginAction() {
		return loginAction;
	}

	public static Action getLogoutAction() {
		return logoutAction;
	}
	
}