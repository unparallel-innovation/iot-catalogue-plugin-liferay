package com.iot_catalogue.asset;

import com.iot_catalogue.model.IoTValidation;
import com.iot_catalogue.portlet.constants.ElementListPortletKeys;
import com.iot_catalogue.service.permission.IoTValidationPermission;
import com.liferay.asset.kernel.model.BaseJSPAssetRenderer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.LayoutConstants;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.StringUtil;
import java.util.Locale;
import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.portlet.PortletURL;
import javax.portlet.WindowState;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.liferay.asset.kernel.model.BaseJSPAssetRenderer;

public class IoTValidationAssetRenderer extends BaseJSPAssetRenderer<IoTValidation> {

	public IoTValidationAssetRenderer(IoTValidation iotValidation) {
		_iotValidation = iotValidation;
	}

	private IoTValidation _iotValidation;

	@Override
	public boolean hasEditPermission(PermissionChecker permissionChecker) throws PortalException {

		return false;
	}

	@Override
	public boolean hasViewPermission(PermissionChecker permissionChecker) throws PortalException {

		long iotValidationId = _iotValidation.getIotValidationId();
		return IoTValidationPermission.contains(permissionChecker, iotValidationId, ActionKeys.VIEW);
	}

	@Override
	public IoTValidation getAssetObject() {
		return _iotValidation;
	}

	@Override
	public long getGroupId() {
		
		long groupId = _iotValidation.getGroupId();
		return groupId;
	}

	@Override
	public long getUserId() {

		return _iotValidation.getUserId();
	}

	@Override
	public String getUserName() {
		return _iotValidation.getUserName();
	}

	@Override
	public String getUuid() {
		return _iotValidation.getUuid();
	}

	@Override
	public String getClassName() {
		return IoTValidation.class.getName();
	}

	@Override
	public long getClassPK() {
		return _iotValidation.getIotValidationId();
	}

	@Override
	public String getSummary(PortletRequest portletRequest, PortletResponse portletResponse) {
		return _iotValidation.getDescription();
	}
	
	@Override
	public String getSearchSummary(Locale locale) {
		return _iotValidation.getDescription();
	}
	
	@Override
	public String getTitle(Locale locale) {

		return _iotValidation.getName();
	}

	@Override
	public boolean include(HttpServletRequest request, HttpServletResponse response, String template) throws Exception {
		request.setAttribute("IOTVALIDATION", _iotValidation);
		request.setAttribute("HtmlUtil", HtmlUtil.getHtml());
		request.setAttribute("StringUtil", new StringUtil());
		return super.include(request, response, template);
	}

	@Override
	public String getJspPath(HttpServletRequest request, String template) {

		if (template.equals(TEMPLATE_FULL_CONTENT)) {
			request.setAttribute("iot_validation", _iotValidation);

			return "/asset/iotvalidation/" + template + ".jsp";
		} else {
			return null;
		}

	}

	/*
	@Override
	public String getURLViewInContext(LiferayPortletRequest liferayPortletRequest,
			LiferayPortletResponse liferayPortletResponse, String noSuchEntryRedirect) throws Exception {
		try {
			long plid = PortalUtil.getPlidFromPortletId(_iotValidation.getGroupId(),
					ElementListPortletKeys.ELEMENT_LIST);

			PortletURL portletURL;
			if (plid == LayoutConstants.DEFAULT_PLID) {
				portletURL = liferayPortletResponse.createLiferayPortletURL(getControlPanelPlid(liferayPortletRequest),
						ElementListPortletKeys.ELEMENT_LIST, PortletRequest.RENDER_PHASE);
			} else {
				portletURL = PortletURLFactoryUtil.create(liferayPortletRequest, ElementListPortletKeys.ELEMENT_LIST,
						plid, PortletRequest.RENDER_PHASE);
			}

			portletURL.setParameter("mvcRenderCommandName", "/elementswebportlet/view.jsp");
			portletURL.setParameter("iotValidationId", String.valueOf(_iotValidation.getIotValidationId()));

			String currentUrl = PortalUtil.getCurrentURL(liferayPortletRequest);

			portletURL.setParameter("redirect", currentUrl);

			return portletURL.toString();

		} catch (PortalException e) {

		} catch (SystemException e) {
		}

		return noSuchEntryRedirect;
	}
*/
	@Override
	public PortletURL getURLEdit(LiferayPortletRequest liferayPortletRequest,
			LiferayPortletResponse liferayPortletResponse) throws Exception {
		PortletURL portletURL = liferayPortletResponse.createLiferayPortletURL(
				getControlPanelPlid(liferayPortletRequest), ElementListPortletKeys.ELEMENT_LIST,
				PortletRequest.RENDER_PHASE);

		portletURL.setParameter("mvcRenderCommandName", "/guestbookwebportlet/edit_entry");
		portletURL.setParameter("entryId", String.valueOf(_iotValidation.getIotValidationId()));
		portletURL.setParameter("showback", Boolean.FALSE.toString());

		return portletURL;
	}

	@Override
	public boolean isPrintable() {
		return true;
	}

	@Override
	public String getURLView(LiferayPortletResponse liferayPortletResponse, WindowState windowState) throws Exception {

		return super.getURLView(liferayPortletResponse, windowState);
	}
}
