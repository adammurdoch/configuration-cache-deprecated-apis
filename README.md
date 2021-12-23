
# Deprecated APIs not supported by the configuration cache

In Gradle 7.4, a number of APIs that are not supported by the configuration cache will be deprecated.
The build in this repo contains examples of each of these.

The deprecations are documented in the [migration guide](https://docs.gradle.org/release-nightly/userguide/upgrading_version_7.html#task_execution_events) (there are 4 sections describing the changes). This documentation will be tweaked
before the 7.4 release.

If you import this build into IDEA, you will see the deprecated usages highlighted in the `build.gradle.kts` script.

The "nags" for the deprecations have been deferred until Gradle 7.5, as they affect many plugins and builds. Deferring
the nags allows some time to work with plugin authors to replace the deprecated usages and for the deprecation
reporting to be improved.

The nags are currently enabled by a feature flag. The `settings.gradle.kts` script for this build enables the feature.
You can see the nags by running:

```
> ./gradlew broken --warning-mode all
```
