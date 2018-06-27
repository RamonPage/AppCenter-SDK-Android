package com.microsoft.appcenter.analytics;

import android.support.annotation.NonNull;

import java.util.HashMap;
import java.util.Map;

/**
 * Target for advanced transmission target usage.
 */
public class AnalyticsTransmissionTarget {

    private final String mTransmissionTargetToken;

    private final Map<String, AnalyticsTransmissionTarget> mChildrenTargets = new HashMap<>();

    /**
     * Create a new instance.
     *
     * @param transmissionTargetToken The token for this transmission target.
     */
    AnalyticsTransmissionTarget(@NonNull String transmissionTargetToken) {
        mTransmissionTargetToken = transmissionTargetToken;
    }

    /**
     * Track a custom event with name.
     *
     * @param name An event name.
     */
    @SuppressWarnings({"WeakerAccess", "SameParameterValue"})
    public void trackEvent(String name) {
        Analytics.trackEvent(name, this);
    }

    /**
     * Track a custom event with name and optional properties.
     * The name parameter can not be null or empty. Maximum allowed length = 256.
     * The properties parameter maximum item count = 5.
     * The properties keys can not be null or empty, maximum allowed key length = 64.
     * The properties values can not be null, maximum allowed value length = 64.
     * Any length of name/keys/values that are longer than each limit will be truncated.
     *
     * @param name       An event name.
     * @param properties Optional properties.
     */
    @SuppressWarnings("WeakerAccess")
    public void trackEvent(String name, Map<String, String> properties) {
        Analytics.trackEvent(name, properties, this);
    }

    /**
     * Create a new transmission target based on the properties of the current target.
     *
     * @param transmissionTargetToken The transmission target token of the new transmission target.
     * @return The new transmission target.
     */
    public synchronized AnalyticsTransmissionTarget getTransmissionTarget(String transmissionTargetToken) {
        AnalyticsTransmissionTarget childTarget = mChildrenTargets.get(transmissionTargetToken);
        if (childTarget == null) {
            childTarget = new AnalyticsTransmissionTarget(transmissionTargetToken);
            mChildrenTargets.put(transmissionTargetToken, childTarget);
        }
        return childTarget;
    }

    /**
     * Getter for transmission target token.
     *
     * @return the transmission target token.
     */
    String getTransmissionTargetToken() {
        return mTransmissionTargetToken;
    }
}
