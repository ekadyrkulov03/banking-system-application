package com.pro.commons.shared.model;

import com.pro.commons.errors.model.ErrorCode;
import com.pro.commons.shared.exception.CurrencyNotFoundException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Getter
public enum Currency {

    KGS((short) 1, "KGS", 2, "Сом"),
    USD((short) 2, "USD", 2, "Доллар"),
    EUR((short) 3, "EUR", 2, "Евро"),
    RUB((short) 4, "RUB", 2, "Рубль");

    private final Short id;
    private final String isoCode;
    private final int fractionDigits;
    private final String name;

    private static final Map<Short, Currency> BY_ID =
            Arrays.stream(values())
                    .collect(Collectors.toMap(
                            Currency::getId,
                            currency -> currency
                    ));

    public static Currency findById(Short id) {
        return Optional.ofNullable(BY_ID.get(id))
                .orElseThrow(() -> new CurrencyNotFoundException(
                        "Unknown currency id: " + id
                ));
    }

}

