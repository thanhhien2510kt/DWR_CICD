package com.DWR.Constant;

import com.DWR.helpers.PropertiesHelper;

public class ConfigData {
    public static String URL = PropertiesHelper.getValue("URL") ;
    public static String USERNAME = PropertiesHelper.getValue("USERNAME") ;
    public static String PASSWORD = PropertiesHelper.getValue("PASSWORD");
    public static int TIMEOUT_EXPLICIT_WAIT = Integer.parseInt(PropertiesHelper.getValue("TIMEOUT_EXPLICIT_WAIT"));
    public static double TIMEOUT_STEP = Double.parseDouble(PropertiesHelper.getValue("TIMEOUT_STEP"));
    public static int TIMEOUT_PAGE_LOAD = Integer.parseInt(PropertiesHelper.getValue("TIMEOUT_PAGE_LOAD"));
    public static String SCREENSHOT_PATH = PropertiesHelper.getValue("SCREENSHOT_PATH");
    public static String RECORD_VIDEO_PATH = PropertiesHelper.getValue("RECORD_VIDEO_PATH");


}
