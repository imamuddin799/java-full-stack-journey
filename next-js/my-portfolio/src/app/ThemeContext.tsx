"use client";

import { createContext, useContext, useEffect, useState } from "react";

/* ─────────────────────────────────────────
   TYPES
───────────────────────────────────────── */
type Theme = "dark" | "light";

interface ThemeContextType {
    theme: Theme;
    toggleTheme: () => void;
}

/* ─────────────────────────────────────────
   CONTEXT
───────────────────────────────────────── */
const ThemeContext = createContext<ThemeContextType>({
    theme: "dark",
    toggleTheme: () => { },
});

/* ─────────────────────────────────────────
   PROVIDER
───────────────────────────────────────── */
export function ThemeProvider({ children }: { children: React.ReactNode }) {
    const [theme, setTheme] = useState<Theme>("dark");

    /* On mount — read saved preference or system preference */
    useEffect(() => {
        const saved = localStorage.getItem("theme") as Theme | null;
        if (saved) {
            setTheme(saved);
            document.documentElement.setAttribute("data-theme", saved);
        } else {
            const prefersDark = window.matchMedia("(prefers-color-scheme: dark)").matches;
            const initial = prefersDark ? "dark" : "light";
            setTheme(initial);
            document.documentElement.setAttribute("data-theme", initial);
        }
    }, []);

    /* Toggle between dark and light */
    const toggleTheme = () => {
        const next = theme === "dark" ? "light" : "dark";
        setTheme(next);
        document.documentElement.setAttribute("data-theme", next);
        localStorage.setItem("theme", next);
    };

    return (
        <ThemeContext.Provider value={{ theme, toggleTheme }}>
            {children}
        </ThemeContext.Provider>
    );
}

/* ─────────────────────────────────────────
   HOOK
───────────────────────────────────────── */
export function useTheme() {
    return useContext(ThemeContext);
}