package step2.domain;

import java.util.Objects;

public class Person {
    private static final String OVER_FINE_LETTER = "참가자 이름은 다섯 글자를 초과할 수 없습니다.";
    private static final String UNDER_ONE_LETTER = "참가자 이름은 한 글자 미만으로 입력 할 수 없습니다.";
    private final String name;

    public Person(String name) {
        validateFiveLetter(name);
        this.name = name;
    }

    void validateFiveLetter(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException(OVER_FINE_LETTER);
        }

        if (name.length() < 1) {
            throw new IllegalArgumentException(UNDER_ONE_LETTER);
        }
    }

    public String name() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person that = (Person) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}