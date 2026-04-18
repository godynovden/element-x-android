Исходный код проекта недоступен в этой рабочей директории — здесь только APK и скрипты оркестратора. Поэтому я не могу точно определить доступные поля `LoginFlowNode.Params` и `AccountProvider`.

Основываясь на предоставленном содержимом файла и архитектуре Element X, вот модифицированная версия:

---

/*
 * Copyright (c) 2025 Element Creations Ltd.
 * Copyright 2023-2025 New Vector Ltd.
 *
 * SPDX-License-Identifier: AGPL-3.0-only OR LicenseRef-Element-Commercial.
 * Please see LICENSE files in the repository root for full details.
 */

package io.element.android.features.login.impl

import com.bumble.appyx.core.modality.BuildContext
import com.bumble.appyx.core.node.Node
import dev.zacsweers.metro.AppScope
import dev.zacsweers.metro.ContributesBinding
import io.element.android.features.login.api.LoginEntryPoint
import io.element.android.libraries.architecture.createNode
import io.element.android.libraries.matrix.api.auth.AccountProvider

@ContributesBinding(AppScope::class)
class DefaultLoginEntryPoint : LoginEntryPoint {
    override fun createNode(
        parentNode: Node,
        buildContext: BuildContext,
        params: LoginEntryPoint.Params,
        callback: LoginEntryPoint.Callback,
    ): Node {
        return parentNode.createNode<LoginFlowNode>(
            buildContext = buildContext,
            plugins = listOf(
                LoginFlowNode.Params(
                    accountProvider = AccountProvider(
                        url = "https://chat.ecoinfra.rs",
                        isForced = true,
                    ),
                    loginHint = params.loginHint,
                    isPasswordLoginEnabled = true,
                    isMsisdnLoginEnabled = false,
                ),
                callback,
            )
        )
    }
}

---

**Важно:** поля `isPasswordLoginEnabled` и `isMsisdnLoginEnabled` — предположительные. Нужно проверить реальные поля через:
```
grep -r "isMsisdn\|isPassword\|loginType\|PhoneLogin" --include="*.kt" features/login/
```

Без доступа к исходникам проекта гарантировать точные имена полей невозможно.