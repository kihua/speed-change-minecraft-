# Deepseek-v4-flash 在 Claude Code 的能力测试项目

## 项目说明

这是一个用于测试 **Deepseek-v4-flash** 在 **Claude Code** 中代码生成能力的简单项目。

项目内容是制作一个非常简易的 **Minecraft Mod（Neoforge 1.21.1版本）**，通过键盘按键 `V` 实现人物移动速度调整。

> 注意：`Ctrl` 键功能失效，仅使用 `V` 键进行速度切换。

## 功能设计

玩家每按一次 `V` 键，人物速度会按照以下顺序切换：

| 按键次数 | 速度加成 |
|---|---|
| 第 1 次 | +100%（2 倍速度） |
| 第 2 次 | +200%（3 倍速度） |
| 第 3 次 | +300%（4 倍速度） |
| 第 4 次 | +400%（5 倍速度） |
| 第 5 次 | 恢复原速 |

## 循环逻辑

按键切换顺序如下：

原速 → 2倍 → 3倍 → 4倍 → 5倍 → 原速


# Other
Installation information
=======

This template repository can be directly cloned to get you started with a new
mod. Simply create a new repository cloned from this one, by following the
instructions provided by [GitHub](https://docs.github.com/en/repositories/creating-and-managing-repositories/creating-a-repository-from-a-template).

Once you have your clone, simply open the repository in the IDE of your choice. The usual recommendation for an IDE is either IntelliJ IDEA or Eclipse.

If at any point you are missing libraries in your IDE, or you've run into problems you can
run `gradlew --refresh-dependencies` to refresh the local cache. `gradlew clean` to reset everything 
{this does not affect your code} and then start the process again.

Mapping Names:
============
By default, the MDK is configured to use the official mapping names from Mojang for methods and fields 
in the Minecraft codebase. These names are covered by a specific license. All modders should be aware of this
license. For the latest license text, refer to the mapping file itself, or the reference copy here:
https://github.com/NeoForged/NeoForm/blob/main/Mojang.md

Additional Resources: 
==========
Community Documentation: https://docs.neoforged.net/  
NeoForged Discord: https://discord.neoforged.net/
