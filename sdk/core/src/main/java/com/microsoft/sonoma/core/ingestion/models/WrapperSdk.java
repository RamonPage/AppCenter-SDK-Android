package com.microsoft.sonoma.core.ingestion.models;

import com.microsoft.sonoma.core.ingestion.models.json.JSONUtils;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

public class WrapperSdk implements Model {

    private static final String WRAPPER_SDK_VERSION = "wrapper_sdk_version";

    private static final String WRAPPER_SDK_NAME = "wrapper_sdk_name";

    private static final String LIVE_UPDATE_RELEASE_LABEL = "live_update_release_label";

    private static final String LIVE_UPDATE_DEPLOYMENT_KEY = "live_update_deployment_key";

    private static final String LIVE_UPDATE_PACKAGE_HASH = "live_update_package_hash";

    /**
     * Version of the wrapper SDK in semver format. When the SDK is embedding another base SDK (for example Xamarin.Android wraps Android),
     * the Xamarin specific version is populated into this field while sdkVersion refers to the original Android SDK.
     */
    private String wrapperSdkVersion;

    /**
     * Name of the wrapper SDK. Consists of the name of the SDK and the wrapper platform, e.g. "avalanchesdk.xamarin", "hockeysdk.cordova".
     */
    private String wrapperSdkName;

    /**
     * Label that is used to identify application code 'version' released via
     * Live Update beacon running on device.
     */
    private String liveUpdateReleaseLabel;

    /**
     * Identifier of environment that current application release belongs to,
     * deployment key then maps to environment like Production, Staging.
     */
    private String liveUpdateDeploymentKey;

    /**
     * Hash of all files (ReactNative or Cordova) deployed to device via
     * LiveUpdate beacon. Helps identify the Release version on device or
     * need to download updates in future.
     */
    private String liveUpdatePackageHash;

    /**
     * Get the wrapperSdkVersion value.
     *
     * @return the wrapperSdkVersion value
     */
    public String getWrapperSdkVersion() {
        return this.wrapperSdkVersion;
    }

    /**
     * Set the wrapperSdkVersion value.
     *
     * @param wrapperSdkVersion the wrapperSdkVersion value to set
     */
    public void setWrapperSdkVersion(String wrapperSdkVersion) {
        this.wrapperSdkVersion = wrapperSdkVersion;
    }

    /**
     * Get the wrapperSdkName value.
     *
     * @return the wrapperSdkName value
     */
    public String getWrapperSdkName() {
        return this.wrapperSdkName;
    }

    /**
     * Set the wrapperSdkName value.
     *
     * @param wrapperSdkName the wrapperSdkName value to set
     */
    public void setWrapperSdkName(String wrapperSdkName) {
        this.wrapperSdkName = wrapperSdkName;
    }

    /**
     * Get the liveUpdateReleaseLabel value.
     *
     * @return the liveUpdateReleaseLabel value
     */
    public String getLiveUpdateReleaseLabel() {
        return this.liveUpdateReleaseLabel;
    }

    /**
     * Set the liveUpdateReleaseLabel value.
     *
     * @param liveUpdateReleaseLabel the liveUpdateReleaseLabel value to set
     */
    public void setLiveUpdateReleaseLabel(String liveUpdateReleaseLabel) {
        this.liveUpdateReleaseLabel = liveUpdateReleaseLabel;
    }

    /**
     * Get the liveUpdateDeploymentKey value.
     *
     * @return the liveUpdateDeploymentKey value
     */
    public String getLiveUpdateDeploymentKey() {
        return this.liveUpdateDeploymentKey;
    }

    /**
     * Set the liveUpdateDeploymentKey value.
     *
     * @param liveUpdateDeploymentKey the liveUpdateDeploymentKey value to set
     */
    public void setLiveUpdateDeploymentKey(String liveUpdateDeploymentKey) {
        this.liveUpdateDeploymentKey = liveUpdateDeploymentKey;
    }

    /**
     * Get the liveUpdatePackageHash value.
     *
     * @return the liveUpdatePackageHash value
     */
    public String getLiveUpdatePackageHash() {
        return this.liveUpdatePackageHash;
    }

    /**
     * Set the liveUpdatePackageHash value.
     *
     * @param liveUpdatePackageHash the liveUpdatePackageHash value to set
     */
    public void setLiveUpdatePackageHash(String liveUpdatePackageHash) {
        this.liveUpdatePackageHash = liveUpdatePackageHash;
    }

    @Override
    public void read(JSONObject object) throws JSONException {
        setWrapperSdkVersion(object.optString(WRAPPER_SDK_VERSION, null));
        setWrapperSdkName(object.optString(WRAPPER_SDK_NAME, null));
        setLiveUpdateReleaseLabel(object.optString(LIVE_UPDATE_RELEASE_LABEL, null));
        setLiveUpdateDeploymentKey(object.optString(LIVE_UPDATE_DEPLOYMENT_KEY, null));
        setLiveUpdatePackageHash(object.optString(LIVE_UPDATE_PACKAGE_HASH, null));
    }

    @Override
    public void write(JSONStringer writer) throws JSONException {
        JSONUtils.write(writer, WRAPPER_SDK_VERSION, getWrapperSdkVersion());
        JSONUtils.write(writer, WRAPPER_SDK_NAME, getWrapperSdkName());
        JSONUtils.write(writer, LIVE_UPDATE_RELEASE_LABEL, getLiveUpdateReleaseLabel());
        JSONUtils.write(writer, LIVE_UPDATE_DEPLOYMENT_KEY, getLiveUpdateDeploymentKey());
        JSONUtils.write(writer, LIVE_UPDATE_PACKAGE_HASH, getLiveUpdatePackageHash());
    }

    @Override
    @SuppressWarnings("SimplifiableIfStatement")
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WrapperSdk that = (WrapperSdk) o;

        if (wrapperSdkVersion != null ? !wrapperSdkVersion.equals(that.wrapperSdkVersion) : that.wrapperSdkVersion != null)
            return false;
        if (wrapperSdkName != null ? !wrapperSdkName.equals(that.wrapperSdkName) : that.wrapperSdkName != null)
            return false;
        if (liveUpdateReleaseLabel != null ? !liveUpdateReleaseLabel.equals(that.liveUpdateReleaseLabel) : that.liveUpdateReleaseLabel != null)
            return false;
        if (liveUpdateDeploymentKey != null ? !liveUpdateDeploymentKey.equals(that.liveUpdateDeploymentKey) : that.liveUpdateDeploymentKey != null)
            return false;
        return liveUpdatePackageHash != null ? liveUpdatePackageHash.equals(that.liveUpdatePackageHash) : that.liveUpdatePackageHash == null;
    }

    @Override
    public int hashCode() {
        int result = wrapperSdkVersion != null ? wrapperSdkVersion.hashCode() : 0;
        result = 31 * result + (wrapperSdkName != null ? wrapperSdkName.hashCode() : 0);
        result = 31 * result + (liveUpdateReleaseLabel != null ? liveUpdateReleaseLabel.hashCode() : 0);
        result = 31 * result + (liveUpdateDeploymentKey != null ? liveUpdateDeploymentKey.hashCode() : 0);
        result = 31 * result + (liveUpdatePackageHash != null ? liveUpdatePackageHash.hashCode() : 0);
        return result;
    }
}
