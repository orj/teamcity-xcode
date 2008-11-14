<%--
 * Copyright (c) 2008 Oliver Jones.  See LICENSE file for details.
--%>

<%@ taglib prefix="props" tagdir="/WEB-INF/tags/props" %>
<%@ taglib prefix="forms" tagdir="/WEB-INF/tags/forms" %>
<%@ taglib prefix="l" tagdir="/WEB-INF/tags/layout" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:useBean id="propertiesBean" scope="request" type="jetbrains.buildServer.controllers.BasePropertiesBean"/>

<l:settingsGroup title="XCodeBuild options">
 
  <tr>   
      <th><label for="xcode.project">XCode Project File: <span class="mandatoryAsterix" title="Mandatory field">*</span></label></th>
    <td>
        <props:textProperty name="xcode.project" className="longField" />
        <span class="error" id="error_xcode.project"></span>
        <span class="smallNote">XCode project file name relative to checkout root.</span>
    </td>
  </tr>
  <tr>
    <c:set var="onclick">
        $('xcode.targetName').disabled = this.checked;
    </c:set>
      <th>
          <label for="targetAll">Build: <span class="mandatoryAsterix" title="Mandatory field">*</span></label>
      </th>
      <td>
        <props:radioButtonProperty name="xcode.target"
                                   onclick="${onclick}"
                                   value="_AllTargets"
                                   id="targetAll" />
        <label for="targetAll">All Targets</label>
        <span class="smallNote">All the targets in the project file.</span>
      </td>
  </tr>
  <tr>
      <td>&nbsp;</td>
      <td>
        <c:set var="onclick">
          $('xcode.targetName').disabled = this.checked;
        </c:set>
        <props:radioButtonProperty name="xcode.target"
                                   onclick="${onclick}"
                                   value="_ActiveTarget"
                                   id="targetActive" />
        <label for="targetActive">Active Target</label>
        <span class="smallNote">The target that is marked as "active" in the project file.</span>
      </td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td>
      <c:set var="onclick">
        $('xcode.targetName').disabled = !this.checked;
        $('xcode.targetName').focus();
      </c:set>
      <props:radioButtonProperty name="xcode.target"
                                 onclick="${onclick}"
                                 value="_Target"
                                 id="target" />
      <label for="target">Target Name:</label>
      <props:textProperty name="xcode.targetName" className="longField"
                          disabled="${propertiesBean.properties['xcode.target'] != '_Target'}"/>
      <span class="error" id="error_xcode.targetName"></span>
      <span class="smallNote">Name of target to build.</span>
    </td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td>
        <props:checkboxProperty name="xcode.parallelizeTargets" />
        <label for="xcode.parallelizeTargets">Parallelize Targets</label>
        <span class="smallNote">Build independent targets in parallel when possible.</span>
    </td>
  </tr>
  <tr>
      <th>
          <label for="xcode.configuration">Configuration: <span class="mandatoryAsterix" title="Mandatory field">*</span></label>
      </th>
      <td><props:textProperty name="xcode.configuration" className="longField" />
        <span class="error" id="error_xcode.configuration"></span>
        <span class="smallNote">The build configuration to use when building the target.</span>
      </td>
  </tr>
  <tr>
      <th>
          <label for="xcode.buildAction">Build Action(s): <span class="mandatoryAsterix" title="Mandatory field">*</span></label>
      </th>
      <td>
        <props:textProperty name="xcode.buildAction" className="longField" />
        <span class="error" id="error_xcode.buildAction"></span>
        <span class="smallNote">Specify a build action (or space seperated list of actions) to perform on the target.
           Available build actions are: clean, build, installsrc, & install.</span>
      </td>
  </tr>
  <tr>
      <th>SDK:</th>
      <td>
          <props:textProperty name="xcode.sdk" />
          <span class="smallNote">Optional.  Specify a specific SDK to build with. 
          eg: macosx10.4, macosx10.5, iphoneos2.1, iphonesimulator2.1, etc.  For a full 
          list run the command 'xcodebuild -showsdks' in a terminal.</span>
      </td>
  </tr>
  <tr>
      <th>Build Settings:</th>
      <td>
        <span class="smallNote">A list of build settings in 
        the format of "setting=value" (without the quotes).
        Sets the build setting 'setting' to 'value'.  One setting per line.</span>
        <props:multilineProperty name="xcode.buildSettings" 
            linkTitle="Edit Build Settings" rows="5" cols="50" />
        <span class="error" id="error_xcode.buildSettings"></span>
      </td>
  </tr>
  <tr>
      <th>User Defaults:</th>
      <td>
        <span class="smallNote">A list of user defaults in 
        the format of "-default=value" (without the quotes).
        Sets the user default 'default' to 'value'. One default per line.</span>
        <props:multilineProperty name="xcode.userDefaults" 
            linkTitle="Edit Build Settings" rows="5" cols="50" />
        <span class="error" id="error_xcode.userDefaults"></span>      
      </td>
  </tr>
</l:settingsGroup>
<%--
<l:settingsGroup title="Distributed Build Options">
     
  <tr>
      <td>&nbsp;</td>
      <td>
          <c:set var="onclick">
            $('xcode.noBonjourBuildHosts').disabled = !this.checked;
            $('xcode.distributeToHostFile').disabled = !this.checked;
            $('xcode.distributeToHostList').disabled = !this.checked;
            $('xcode.buildHostList').disabled = !this.checked;
            $('xcode.buildHostFile').disabled = !this.checked;
          </c:set>
          <props:checkboxProperty  
            name="xcode.distributeBuilds" 
            value="true"
            checked="${propertiesBean.properties['xcode.distributeBuilds'] == 'true'}"
            onclick="${onclick}" />
          <label for="xcode.distributeBuilds">Distribute Builds</label>
          <span class="smallNote">Check to enable distributed builds.</span>
      </td>
  </tr>

  <tr>
      <td>&nbsp;</td>
      <td>
          <props:checkboxProperty name="xcode.noBonjourBuildHosts" 
            value="true" 
            checked="${propertiesBean.properties['xcode.noBonjourBuildHosts'] == 'true'}"
            disabled="${propertiesBean.properties['xcode.distributeBuilds'] != 'true'}"
            />
          <label for="xcode.noBonjourBuildHosts">No Bonjour Build Hosts</label>
          <span class="smallNote">Do not search for build machines using Bonjour. Overrides the 
           Bonjour distributed build setting stored in the user defaults by the
           Xcode preferences panel.</span>
      </td>
  </tr>
   
  <tr>
      <th><strong>Distribute To Hosts:</strong></th>
      <td>
          <c:set var="onclick">
            $('xcode.buildHostList').disabled = !this.checked;
            $('xcode.buildHostList').focus();
            $('xcode.buildHostFile').disabled = this.checked;
          </c:set>
          <props:radioButtonProperty 
            id="xcode.distributeToHostList"
            name="xcode.distributeTo"
            onclick="${onclick}"
            value="_HostList" 
            disabled="${propertiesBean.properties['xcode.distributeBuilds'] != 'true'}" />
          <label for="xcode.distributeToHostList">Host List</label>
          <props:multilineProperty 
            name="xcode.buildHostList" 
            disabled="${propertiesBean.properties['xcode.distributeBuilds'] != 'true'}"
            linkTitle="Edit Host List" rows="5" cols="50" />
      </td>

  </tr>
  <tr>
      <td>&nbsp;</td>
      <td>
          <c:set var="onclick">
            $('xcode.buildHostFile').disabled = !this.checked;
            $('xcode.buildHostFile').focus();
            $('xcode.buildHostList').disabled = this.checked;
          </c:set>
          <props:radioButtonProperty 
            id="xcode.distributeToHostFile"
            name="xcode.distributeTo"
            onclick="${onclick}"
            value="_HostFile" 
            disabled="${propertiesBean.properties['xcode.distributeBuilds'] != 'true'}"/>
          <label for="xcode.distributeToHostFile">Host File:</label>
          <props:textProperty 
            name="xcode.buildHostFile" className="longField" 
            disabled="${propertiesBean.properties['xcode.distributeBuilds'] != 'true' && propertiesBean.properties['xcode.distributeTo'] != '_HostFile'}"
            />
          <span class="smallNote">The hostsfile is a text file containing
          build machine names, one per line.</span>
      </td>    
  </tr>
 
</l:settingsGroup>
--%>