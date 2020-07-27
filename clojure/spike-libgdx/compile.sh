#!/bin/bash
native-image --initialize-at-build-time --report-unsupported-elements-at-runtime --no-server --no-fallback -H:+ReportExceptionStackTraces -H:ReflectionConfigurationFiles=reflection-config.json -cp $(cat .cpcache/*.cp) demo.desktop_launcher my_demo_game
