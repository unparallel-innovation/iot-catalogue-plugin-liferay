/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.iot_catalogue.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the IoTValidation service. Represents a row in the &quot;IoTCatalogue_IoTValidation&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see IoTValidationModel
 * @generated
 */
@ImplementationClassName("com.iot_catalogue.model.impl.IoTValidationImpl")
@ProviderType
public interface IoTValidation extends IoTValidationModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>com.iot_catalogue.model.impl.IoTValidationImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<IoTValidation, Long>
		IOT_VALIDATION_ID_ACCESSOR = new Accessor<IoTValidation, Long>() {

			@Override
			public Long get(IoTValidation ioTValidation) {
				return ioTValidation.getIotValidationId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<IoTValidation> getTypeClass() {
				return IoTValidation.class;
			}

		};

}