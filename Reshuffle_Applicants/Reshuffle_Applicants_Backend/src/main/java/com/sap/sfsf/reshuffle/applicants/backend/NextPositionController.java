package com.sap.sfsf.reshuffle.applicants.backend;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.sap.cloud.sdk.odatav2.connectivity.ODataException;
import com.sap.sfsf.reshuffle.applicants.backend.model.NextPosition;
import com.sap.sfsf.reshuffle.applicants.backend.model.filters.CurrentPositionFilter;
import com.sap.sfsf.reshuffle.applicants.backend.services.NextPositionService;
import com.sap.sfsf.reshuffle.applicants.backend.util.EmptyConfigException;
import com.sap.sfsf.reshuffle.applicants.backend.util.validator.NextPositionReqParamsValidator;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@RestController
@RequestMapping("/")
public class NextPositionController {
    Logger logger = LoggerFactory.getLogger(NextPositionController.class);

    @Autowired
	NextPositionService nextPositionService;

	@GetMapping(value = "/nextpositions", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	String getNextPositions(@RequestParam Map<String, String> params) throws ODataException, EmptyConfigException {
        long start = System.currentTimeMillis();
        logger.info("==================================nextposition controller");

		NextPositionReqParamsValidator pValidator = new NextPositionReqParamsValidator(params);

		if(pValidator.isBadRequest() == true) {
			Optional<String> result = pValidator.getProblemList().stream().reduce(
					(accum, value) -> {
						return accum + ", "  + value;
					});
			logger.error("Filter Validation Error(s) : " + result.orElse(""));
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		} else {
			CurrentPositionFilter candidateFilter = new CurrentPositionFilter(params);
			List<NextPosition> list = null;

			list = nextPositionService.findAllfromSfsfNP(candidateFilter);
			Gson gson = new GsonBuilder().serializeNulls().create();

			long end = System.currentTimeMillis();
			logger.info("Exec Time: GET /nextpositions, " + (end - start) + "ms");

			return gson.toJson(list);
		}
	}
}
