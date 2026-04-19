/*
 * Copyright (c) 2025 Matrix Messenger.
 *
 * SPDX-License-Identifier: AGPL-3.0-only
 */

package config

object BuildTimeConfig {
    const val APPLICATION_ID = "rs.ecoinfra.matrix"
    const val APPLICATION_NAME = "Matrix"
    const val GOOGLE_APP_ID_RELEASE = "1:12830939977:android:c2ec31e96186bc39d45898"
    const val GOOGLE_APP_ID_DEBUG = "1:12830939977:android:c2ec31e96186bc39d45898"
    const val GOOGLE_APP_ID_NIGHTLY = "1:12830939977:android:c2ec31e96186bc39d45898"

    val METADATA_HOST_REVERSED: String? = null
    val URL_WEBSITE: String? = null
    val URL_LOGO: String? = null
    val URL_COPYRIGHT: String? = null
    val URL_ACCEPTABLE_USE: String? = null
    val URL_PRIVACY: String? = null
    val URL_POLICY: String? = null
    val SERVICES_MAPTILER_BASE_URL: String? = null
    val SERVICES_MAPTILER_APIKEY: String? = null
    val SERVICES_MAPTILER_LIGHT_MAPID: String? = null
    val SERVICES_MAPTILER_DARK_MAPID: String? = null
    val SERVICES_POSTHOG_HOST: String? = null
    val SERVICES_POSTHOG_APIKEY: String? = null
    val SERVICES_SENTRY_DSN: String? = null
    val SERVICES_SENTRY_DSN_RUST: String? = null
    val BUG_REPORT_URL: String? = null
    val BUG_REPORT_APP_NAME: String? = null

    const val PUSH_CONFIG_INCLUDE_FIREBASE = true
    const val PUSH_CONFIG_INCLUDE_UNIFIED_PUSH = true
}
