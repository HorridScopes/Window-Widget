# Window Widget

A modern Java desktop widget that displays the current time, date, and system/user information in a visually appealing overlay.

## Key Features

- **Dynamic Time and Date Display:**  
  Shows the current time (with seconds) and date, using dynamically sized and centered fonts for clarity and style.

- **System/User Information:**  
  Displays the current user's name (from system properties) and the current system time in milliseconds as side information.

- **Custom Graphics Pipeline:**  
  Uses a modular `GraphicsController` to handle all drawing, including backgrounds, text, and side info, with double buffering for smooth visuals.

- **Resource Management:**  
  Fonts and other assets are loaded and cached via `ResourceHandler` for efficient rendering.

- **Extensible Architecture:**  
  The code is organized for easy maintenance and future enhancements, such as adding more system info or visual styles.

## How It Works

- The application starts in `Screen.java`, which sets up the main window and initializes resources.
- `ResourceHandler` loads and caches fonts and other assets.
- `GraphicsController` draws the background, time, date, and side information, using the loaded resources and double buffering.
- `Information` provides utilities for formatting and retrieving date, time, and text layout.

## Recent Enhancements

- **Date and Side Info:**  
  The widget now displays the current date and additional system items (user name and millisecond time).
- **Improved Modularity:**  
  Drawing routines for time, date, and side info are now clearly separated and reusable.
- **Consistent Font Usage:**  
  All text rendering uses cached fonts for performance and consistency.

This modular structure makes the project easy to maintain and extend, allowing for future enhancements such as additional information displays, new visual styles, or more resource types.
