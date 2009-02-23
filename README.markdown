TeamCity XCode Integration
==========================

xcodebuild Runner
-----------------
This is a plugin for TeamCity 4.0.2 that provides a build agent runner that
invokes the xcodebuild command on MacOS X build agent hosts.

Installation
------------
Grab the xcode-plugin.zip from the dist/ directory and place it in your
TeamCity data directory's plugin subdirectory.  Usually ~/.BuildServer/plugins 
for the user running the TeamCity server.

Once the zip file has been placed in the plugin directory, restart the TeamCity
server.