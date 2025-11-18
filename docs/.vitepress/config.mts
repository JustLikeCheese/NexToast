import { defineConfig } from 'vitepress'

export default defineConfig({
  // 默认语言
  lang: 'en-US',
  
  // 网站标题（会显示在浏览器标签页）
  title: 'NexToast',
  
  // 网站描述（SEO）
  description: 'A Android Toast library that removes restrictions',
  
  // 网站图标
  head: [
    ['link', { rel: 'icon', href: '/favicon.ico' }]
  ],
  
  locales: {
    root: {
      label: 'English',
      lang: 'en-US',
      title: "NexToast",
      description: "A Android Toast library that removes restrictions",
      themeConfig: {
        nav: [
          { text: 'Home', link: '/' },
          { text: 'Get Started', link: '/#usage' },
          { text: 'Preview', link: '/#preview' }
        ],
        
        // 页脚
        footer: {
          message: 'Released under the WTFPL License.',
          copyright: 'Copyright © 2025 JustLikeCheese'
        },
        
        // 编辑链接
        editLink: {
          pattern: 'https://github.com/JustLikeCheese/NexToast/edit/main/docs/:path',
          text: 'Edit this page on GitHub'
        },
        
        // 社交链接
        socialLinks: [
          { icon: 'github', link: 'https://github.com/JustLikeCheese/NexToast' },
          { 
            icon: {
              svg: '<svg role="img" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg"><title>Telegram</title><path d="M11.944 0A12 12 0 0 0 0 12a12 12 0 0 0 12 12 12 12 0 0 0 12-12A12 12 0 0 0 12 0a12 12 0 0 0-.056 0zm4.962 7.224c.1-.002.321.023.465.14a.506.506 0 0 1 .171.325c.016.093.036.306.02.472-.18 1.898-.962 6.502-1.36 8.627-.168.9-.499 1.201-.82 1.23-.696.065-1.225-.46-1.9-.902-1.056-.693-1.653-1.124-2.678-1.8-1.185-.78-.417-1.21.258-1.91.177-.184 3.247-2.977 3.307-3.23.007-.032.014-.15-.056-.212s-.174-.041-.249-.024c-.106.024-1.793 1.14-5.061 3.345-.48.33-.913.49-1.302.48-.428-.008-1.252-.241-1.865-.44-.752-.245-1.349-.374-1.297-.789.027-.216.325-.437.893-.663 3.498-1.524 5.83-2.529 6.998-3.014 3.332-1.386 4.025-1.627 4.476-1.635z"/></svg>'
            }, 
            link: 'https://t.me/NexLua' 
          }
        ],
        
        // 搜索
        search: {
          provider: 'local'
        }
      }
    },
    zh: {
      label: '简体中文',
      lang: 'zh-CN',
      title: "NexToast",
      description: "一个自由的安卓 Toast 库，移除原版限制",
      themeConfig: {
        nav: [
          { text: '主页', link: '/zh/' },
          { text: '快速开始', link: '/zh/#在项目中使用' },
          { text: '效果预览', link: '/zh/#效果预览' }
        ],
        
        // 页脚
        footer: {
          message: '基于 WTFPL 许可发布',
          copyright: 'Copyright © 2025 JustLikeCheese'
        },
        
        // 编辑链接
        editLink: {
          pattern: 'https://github.com/JustLikeCheese/NexToast/edit/main/docs/:path',
          text: '在 GitHub 上编辑此页'
        },
        
        // 文档页脚文本
        docFooter: {
          prev: '上一页',
          next: '下一页'
        },
        
        // 大纲标题
        outlineTitle: '页面导航',
        
        // 返回顶部文本
        returnToTopLabel: '返回顶部',
        
        // 外部链接图标
        externalLinkIcon: true,
        
        // 社交链接
        socialLinks: [
          { icon: 'github', link: 'https://github.com/JustLikeCheese/NexToast' },
          { 
            icon: {
              svg: '<svg role="img" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg"><title>Telegram</title><path d="M11.944 0A12 12 0 0 0 0 12a12 12 0 0 0 12 12 12 12 0 0 0 12-12A12 12 0 0 0 12 0a12 12 0 0 0-.056 0zm4.962 7.224c.1-.002.321.023.465.14a.506.506 0 0 1 .171.325c.016.093.036.306.02.472-.18 1.898-.962 6.502-1.36 8.627-.168.9-.499 1.201-.82 1.23-.696.065-1.225-.46-1.9-.902-1.056-.693-1.653-1.124-2.678-1.8-1.185-.78-.417-1.21.258-1.91.177-.184 3.247-2.977 3.307-3.23.007-.032.014-.15-.056-.212s-.174-.041-.249-.024c-.106.024-1.793 1.14-5.061 3.345-.48.33-.913.49-1.302.48-.428-.008-1.252-.241-1.865-.44-.752-.245-1.349-.374-1.297-.789.027-.216.325-.437.893-.663 3.498-1.524 5.83-2.529 6.998-3.014 3.332-1.386 4.025-1.627 4.476-1.635z"/></svg>'
            }, 
            link: 'https://t.me/NexLua' 
          }
        ],
        
        // 搜索
        search: {
          provider: 'local',
          options: {
            translations: {
              button: {
                buttonText: '搜索文档',
                buttonAriaLabel: '搜索文档'
              },
              modal: {
                noResultsText: '无法找到相关结果',
                resetButtonTitle: '清除查询条件',
                footer: {
                  selectText: '选择',
                  navigateText: '切换'
                }
              }
            }
          }
        }
      }
    }
  }
})