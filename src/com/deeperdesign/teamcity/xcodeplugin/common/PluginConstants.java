/*
 * Copyright (c) 2008 Oliver Jones.  All rights reserved.
 */

package com.deeperdesign.teamcity.xcodeplugin.common;
import jetbrains.buildServer.agent.Constants;

/**
 *
 * @author oliver
 */
public interface PluginConstants {

    String XCODE_ROOT_PROPERTY = Constants.SYSTEM_PREFIX + "XCodeRoot";
    String XCODECMD_FILE_VERSION_PROPERTY = Constants.SYSTEM_PREFIX + "XCodeCmdFileVersion";

    String RUNNER_TYPE = "XCode";
    
    String SETTINGS_XCODE_PROJECT = "xcode.project";
    String SETTINGS_XCODE_TARGET = "xcode.target";
    String SETTINGS_XCODE_TARGET_ACTIVETARGET = "_ActiveTarget";
    String SETTINGS_XCODE_TARGET_ALLTARGETS = "_AllTargets";
    String SETTINGS_XCODE_TARGET_SINGLETARGET = "_Target";
    
    String SETTINGS_XCODE_TARGET_DEFAULT = SETTINGS_XCODE_TARGET_ALLTARGETS;
    String SETTINGS_XCODE_TARGETNAME = "xcode.targetName";
    
    String SETTINGS_XCODE_PARALLELIZETARGETS = "xcode.parallelizeTargets";
    String SETTINGS_XCODE_PARALLELIZETARGETS_DEFAULT = "true";
    
    String SETTINGS_XCODE_CONFIGURATION = "xcode.configuration";
    String SETTINGS_XCODE_CONFIGURATION_DEFAULT = "Release";
    
    String SETTINGS_XCODE_BUILD_ACTION = "xcode.buildAction";
    String SETTINGS_XCODE_BUILD_ACTION_DEFAULT = "build";    
    
    String SETTINGS_XCODE_SDK = "xcode.sdk";
    
    String SETTINGS_XCODE_BUILD_SETTINGS = "xcode.buildSettings";
    String SETTINGS_XCODE_USER_DEFAULTS = "xcode.userDefaults";
    
    String SETTINGS_XCODE_DISTRIBUTEBUILDS = "xcode.distributeBuilds";    
    String SETTINGS_XCODE_NOBONJOURBUILDHOSTS = "xcode.noBonjourBuildHosts";
        
    String RUNNER_DISPLAY_NAME = "XCode";
    String RUNNER_DESCRIPTION = "XCode Project Builder";
   
}
