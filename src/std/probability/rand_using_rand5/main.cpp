int rand7() {
    while (1) {
        int num = 5 * (rand5() - 1) + rand5();
        if (num < 22) return ((num % 7) + 1);
    }
}

