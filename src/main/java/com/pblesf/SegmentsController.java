/*
 * [y] hybris Platform
 *
 * Copyright (c) 2000-2016 hybris AG
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of hybris
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with hybris.
 */
package com.pblesf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/segments")
public class SegmentsController
{
	@Autowired
	private SegmentService segmentService;


	@RequestMapping(
			value = "/mySegments",
			method = RequestMethod.GET,
			produces = {"application/json", "application/xml"})
	@ResponseBody
	String getStarredSegments(@RequestParam(value = "city", required = false) final String city)
	{
		return segmentService.getMySegments(city);

//		return "Here I'll present my starred segments";
	}
}
