/* global QUnit */
QUnit.config.autostart = false;

sap.ui.getCore().attachInit(function () {
	"use strict";

	sap.ui.require([
		"com/sap/sfsf/Reshuffle_Simulation_UI/test/integration/AllJourneys"
	], function () {
		QUnit.start();
	});
});