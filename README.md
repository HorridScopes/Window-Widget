# Window Widget

This project creates a visually appealing GUI widget for displaying the current date, time, and other notable information on your desktop.

## Key Features

- **Modern GUI Display:**
  Presents date, time, and additional information in a sleek, unobtrusive window overlay.

- **Java Swing with Double Buffering:**
  Utilizes Java Swing for the user interface, and implements double buffering via a custom `GraphicsController` class. This ensures fast, flicker-free, and smooth rendering of graphics, even during frequent updates.

- **Custom Graphics Handling (`GraphicsController`):**
  All drawing operations are modularized in `GraphicsController.java`, which manages the creation of transparent, gradient backgrounds and handles all rendering logic for a polished look. Recent updates have improved text rendering, background drawing, and double-buffered graphics for smooth updates.

- **Resource Management (`ResourceHandler`):**
  Fonts and other resources are loaded and cached efficiently using `ResourceHandler.java`, which now supports loading custom fonts from the `resources` directory for use in the GUI.

- **Main Application Logic (`Screen`):**
  The main window logic is handled in `Screen.java`, which creates the main visual overlay and integrates the graphics and resource management for a seamless user experience. Mouse events and window positioning are managed here.

- **Date/Time Formatting (`Information`):**
  The `Information.java` class provides a foundation for formatting and handling date/time display, making it easy to update or localize the widget's output.

## How These Components Work Together

- The application starts in `Screen.java`, which sets up the main window and initializes resources.
- `ResourceHandler` loads and caches fonts and other assets, making them available for rendering.
- `GraphicsController` is responsible for all drawing, including backgrounds and text, using the loaded resources and double buffering for smooth visuals.
- `Information` provides formatting utilities for displaying the current date and time in the widget.

This modular structure makes the project easy to maintain and extend, allowing for future enhancements such as additional information displays, new visual styles, or more resource types.
