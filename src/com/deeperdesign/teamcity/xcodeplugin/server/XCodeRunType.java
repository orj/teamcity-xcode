/*
 * Copyright (c) 2008 Oliver Jones.  All rights reserved.
 */

package com.deeperdesign.teamcity.xcodeplugin.server;

import com.deeperdesign.teamcity.xcodeplugin.common.PluginConstants;

import java.util.HashMap;
import java.util.Map;
import jetbrains.buildServer.serverSide.*;

/**
 *
 * @author oliver
 */
public class XCodeRunType extends RunType {

    private Map<String, String> _defaultProperties = null;
    
    public XCodeRunType(final RunTypeRegistry runTypeRegistry) {
        runTypeRegistry.registerRunType(this);
    }

    
    @Override
    public String getType() {
        return PluginConstants.RUNNER_TYPE;
    }

    @Override
    public String getDisplayName() {
        return PluginConstants.RUNNER_DISPLAY_NAME;
    }

    @Override
    public String getDescription() {
        return PluginConstants.RUNNER_DESCRIPTION;
    }

    @Override
    public PropertiesProcessor getRunnerPropertiesProcessor() {
        return new XCodeRunTypePropertiesProcessor();
    }

    @Override
    public String getEditRunnerParamsJspFilePath() {
        return "editXCodeRunParams.jsp";
    }

    @Override
    public String getViewRunnerParamsJspFilePath() {
        return "viewXCodeRunParams.jsp";
    }

    @Override
    public Map<String, String> getDefaultRunnerProperties() {
        if(_defaultProperties == null) {
            _defaultProperties = new HashMap<String, String>();
            setUpDefaultParams(_defaultProperties);
        }

        return _defaultProperties;

    }

    private void setUpDefaultParams(Map<String, String> params) {
        
        params.put(PluginConstants.SETTINGS_XCODE_TARGET, 
                   PluginConstants.SETTINGS_XCODE_TARGET_DEFAULT);
        
        params.put(PluginConstants.SETTINGS_XCODE_PARALLELIZETARGETS,
                PluginConstants.SETTINGS_XCODE_PARALLELIZETARGETS_DEFAULT);
        
        params.put(PluginConstants.SETTINGS_XCODE_CONFIGURATION,
                PluginConstants.SETTINGS_XCODE_CONFIGURATION_DEFAULT);
        
        params.put(PluginConstants.SETTINGS_XCODE_BUILD_ACTION,
                PluginConstants.SETTINGS_XCODE_BUILD_ACTION_DEFAULT);
 
    }

}
