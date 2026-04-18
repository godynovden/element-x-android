Файл проекта не доступен в рабочей директории. Основываясь на структуре Element X Android и описании задачи, вот изменённое содержимое файла:

```kotlin
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
                ),
                callback,
            )
        )
    }
}
```

**Важно:** Точный пакет для `AccountProvider` и поля конструктора зависят от версии Element X. Нужно проверить:
1. Где определён `AccountProvider` — запусти `grep -r "class AccountProvider" --include="*.kt"` в проекте
2. Какое поле отвечает за принудительное скрытие экрана сервера (`isForced`, `isCustom`, и т.п.)

Без доступа к самому проекту я не могу гарантировать точные имена полей и импорт.