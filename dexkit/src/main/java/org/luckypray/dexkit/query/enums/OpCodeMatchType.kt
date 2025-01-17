package org.luckypray.dexkit.query.enums

import org.luckypray.dexkit.InnerOpCodeMatchType

enum class OpCodeMatchType(val value: Byte) {
    Contains(InnerOpCodeMatchType.Contains),
    StartWith(InnerOpCodeMatchType.StartWith),
    EndWith(InnerOpCodeMatchType.EndWith),
    Equal(InnerOpCodeMatchType.Equal),
    ;
}