# SpeedChange / 速度切换

[![Build](https://github.com/kihua/speed-change-minecraft/actions/workflows/build.yml/badge.svg)](https://github.com/kihua/speed-change-minecraft/actions/workflows/build.yml)
[![NeoForge](https://img.shields.io/badge/NeoForge-21.1.227-blue)](https://neoforged.net/)
[![Minecraft](https://img.shields.io/badge/Minecraft-1.21.1-green)](https://minecraft.net/)
[![License](https://img.shields.io/badge/License-All%20Rights%20Reserved-red)]()

---

**English** | [中文](#安装)

A Minecraft NeoForge mod that lets you cycle through multiple movement speed levels by pressing a key.

Toggle between speed levels on-the-fly — perfect for creative mode building, server administration, exploring, or just getting around faster. Each level stacks a configurable speed boost, and you can customize both the number of levels and the boost amount.

---

## Features

- **一键切换** — Press `V` (configurable) to cycle through speed levels
- **可配置等级** — Up to 20 speed levels (default: 4), configurable in `config/speed_change-common.toml`
- **可配置增量** — Customize how much speed each level adds (default: +0.1 per level)
- **实时 HUD** — Displays current speed bonus in the top-right corner of the screen
- **服务端同步** — Speed level persists on the server; works in multiplayer
- **配置界面** — Supports NeoForge's built-in config screen (accessible via Mod Menu)

## Installation

1. Install **NeoForge 21.1.227** for Minecraft 1.21.1
2. Download the latest `speed_change-x.x.x.jar` from [Releases](https://github.com/kihua/speed-change-minecraft/releases)
3. Place the `.jar` file into your `mods/` folder
4. Launch the game with the NeoForge profile

## Usage

| Action              | Keybind                        |
|---------------------|--------------------------------|
| Cycle speed level   | `V`                            |
| Change keybind      | Settings → Controls → Speed Change → Cycle Speed Boost |

Each press of `V` advances to the next level. After reaching the maximum level, the next press resets to level 0 (normal speed).

The HUD in the top-right corner shows your current speed bonus, e.g., `Speed: +200%` at level 2 with default settings.

## Configuration

The config file is located at `config/speed_change-common.toml` after first launch.

### Options

| Option             | Type   | Default | Description                          |
|--------------------|--------|---------|--------------------------------------|
| `speed_increment`  | Double | `0.1`   | Speed boost added per level          |
| `max_level`        | Integer| `4`     | Maximum number of speed levels       |

### Example

```toml
#config/speed_change-common.toml

[SpeedChange]
	speed_increment = 0.15
	max_level = 6
```

With the example above:
- Level 1: +0.15 speed (+15%)
- Level 2: +0.30 speed (+30%)
- Level 3: +0.45 speed (+45%)
- Level 6: +0.90 speed (+90%)

### Note
In creative mode, the default base movement speed is 0.15 (vs. 0.1 in survival). Keep this in mind when setting high values.

---

## Building from Source

```bash
git clone https://github.com/kihua/speed-change-minecraft.git
cd speed-change-minecraft
./gradlew build
```

The built jar will be in `build/libs/`.

---

## 功能

- **一键切换** — 按下 `V` 键（可自定义）切换速度等级
- **可配置等级** — 最多 20 级（默认 4 级），在 `config/speed_change-common.toml` 中配置
- **可配置增量** — 自定义每级增加多少速度（默认每级 +0.1）
- **实时 HUD** — 屏幕右上角显示当前速度加成百分比
- **服务端同步** — 速度等级保存在服务端，多人游戏可用
- **配置界面** — 支持 NeoForge 内置配置界面（可通过模组菜单访问）

## 安装

1. 为 Minecraft 1.21.1 安装 **NeoForge 21.1.227**
2. 从 [Releases](https://github.com/kihua/speed-change-minecraft/releases) 下载最新的 `speed_change-x.x.x.jar`
3. 将 `.jar` 文件放入 `mods/` 文件夹
4. 使用 NeoForge 配置文件启动游戏

## 使用说明

| 操作             | 按键                         |
|------------------|------------------------------|
| 切换速度等级     | `V`                          |
| 更改按键         | 设置 → 控制 → Speed Change → Cycle Speed Boost |

每按一次 `V` 键切换到下一级。达到最大等级后，再次按下将重置为 0 级（正常速度）。

屏幕右上角的 HUD 会显示当前速度加成，例如默认设置下 2 级时显示 `速度: +200%`。

## 配置说明

配置文件在首次启动后位于 `config/speed_change-common.toml`。

### 配置项

| 配置项             | 类型   | 默认值    | 说明                      |
|--------------------|--------|-----------|---------------------------|
| `speed_increment`  | Double | `0.1`     | 每级增加的速度值          |
| `max_level`        | Integer| `4`       | 最大速度等级数            |

### 示例

```toml
#config/speed_change-common.toml

[SpeedChange]
	speed_increment = 0.15
	max_level = 6
```

以上配置的效果：
- 1 级：速度 +0.15（+15%）
- 2 级：速度 +0.30（+30%）
- 3 级：速度 +0.45（+45%）
- 6 级：速度 +0.90（+90%）

### 注意
创造模式下基础移动速度为 0.15（生存模式为 0.1），配置高值时请注意。

---

## 从源码构建

```bash
git clone https://github.com/kihua/speed-change-minecraft.git
cd speed-change-minecraft
./gradlew build
```

构建好的 jar 文件在 `build/libs/` 目录下。

---

## License / 许可

All Rights Reserved.
