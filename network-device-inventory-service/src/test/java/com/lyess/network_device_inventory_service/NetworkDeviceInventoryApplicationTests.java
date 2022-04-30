package com.lyess.network_device_inventory_service;

import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

@Suite
@SelectPackages({"com.lyess.network_device_inventory.controller",
        "com.lyess.network_device_inventory.service",
        "com.lyess.network_device_inventory.repository"})
@SuiteDisplayName("NetworkDeviceInventoryApplicationTestSuite")
class NetworkDeviceInventoryApplicationTests {

}
