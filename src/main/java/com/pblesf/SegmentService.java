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

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import javastrava.api.v3.auth.AuthorisationService;
import javastrava.api.v3.auth.impl.retrofit.AuthorisationServiceImpl;
import javastrava.api.v3.auth.model.Token;
import javastrava.api.v3.model.StravaSegment;
import javastrava.api.v3.service.Strava;

@Component
public class SegmentService
{
	public static final String CLIENT_SECRET = "a6ed8b3adeb2d08efdbf0012fb53f862079329f6";
	public static final int CLIENT_ID = 12093;
	public static final String CODE = "76bcde25bfef73f7eab20ae76b85f0e0a2dc271b";


	public String getMySegments(final String city)
	{
		AuthorisationService service = new AuthorisationServiceImpl();
		Token token = service.tokenExchange(
				CLIENT_ID, CLIENT_SECRET, CODE);
		Strava strava = new Strava(token);

		final List<StravaSegment> stravaSegments = strava.listAllAuthenticatedAthleteStarredSegments();
		final Map<Integer, String> segments = stravaSegments.stream().collect(Collectors.toMap(StravaSegment::getId, StravaSegment::getName));

		return segments.toString();
	}
}
