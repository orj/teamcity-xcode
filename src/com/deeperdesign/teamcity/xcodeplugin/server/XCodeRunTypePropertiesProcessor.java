/*
 * Copyright (c) 2008 Oliver Jones.  See LICENSE file for details.
 */

package com.deeperdesign.teamcity.xcodeplugin.server;

import com.deeperdesign.teamcity.xcodeplugin.common.PluginConstants;
import jetbrains.buildServer.serverSide.InvalidProperty;
import jetbrains.buildServer.serverSide.PropertiesProcessor;
import jetbrains.buildServer.util.PropertiesUtil;
import java.util.List;
import java.util.Vector;
import java.util.Collection;
import java.util.Map;

/**
 *
 * @author oliver
 */
public class XCodeRunTypePropertiesProcessor implements PropertiesProcessor {

    public Collection<InvalidProperty> process(Map<String, String> properties) {
        List<InvalidProperty> result = new Vector<InvalidProperty>();
        
        final String project = (String)properties.get(PluginConstants.SETTINGS_XCODE_PROJECT);
        final String target = (String)properties.get(PluginConstants.SETTINGS_XCODE_TARGET);
        final String config = (String)properties.get(PluginConstants.SETTINGS_XCODE_CONFIGURATION);
        final String action = (String)properties.get(PluginConstants.SETTINGS_XCODE_BUILD_ACTION);
        
        if (PropertiesUtil.isEmptyOrNull(project)) {
          result.add(
            new InvalidProperty(
                PluginConstants.SETTINGS_XCODE_PROJECT,
                "XCode project file must be specified."));
        }
        
        if(PropertiesUtil.isEmptyOrNull(target)) {
            result.add(
                    new InvalidProperty(PluginConstants.SETTINGS_XCODE_TARGET, 
                    "XCode target must be specified."));
        } else {
            final String targetName = (String)properties.get(PluginConstants.SETTINGS_XCODE_TARGETNAME);
            if(target.equals(PluginConstants.SETTINGS_XCODE_TARGET_SINGLETARGET) &&
                    PropertiesUtil.isEmptyOrNull(targetName)) {
                result.add(
                        new InvalidProperty(PluginConstants.SETTINGS_XCODE_TARGETNAME,
                        "XCode target name must be specified."));
            }
        }
        
        if(PropertiesUtil.isEmptyOrNull(config)) {
            result.add(
                    new InvalidProperty(PluginConstants.SETTINGS_XCODE_CONFIGURATION,
                    "XCode project configuration must be specified."));
        }
        
        if(PropertiesUtil.isEmptyOrNull(action)){
            result.add(
                    new InvalidProperty(PluginConstants.SETTINGS_XCODE_BUILD_ACTION,
                    "XCode project build action must be specified."));
        }
                
        return result;
    }

}
